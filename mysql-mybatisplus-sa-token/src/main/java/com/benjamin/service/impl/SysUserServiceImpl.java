package com.benjamin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjamin.converter.SaTokenConverter;
import com.benjamin.dto.SysUserDto;
import com.benjamin.entities.SysUser;
import com.benjamin.dao.SysUserMapper;
import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2023-12-16
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SaTokenConverter saTokenConverter;



    /**
     * 登录
     *
     * @param sysUserDto
     * @return
     */
    @Override
    public ResponseWithEntities<SysUserVo> login(SysUserDto sysUserDto) {

        // 身份证号
        String idNumber = sysUserDto.getIdNumber();
        if (!IdcardUtil.isValidCard(idNumber))
            throw new WebException(SystemErrors.ID_NUMBER_ILLEGAL);

        // 手机号
        String phone = sysUserDto.getPhone();
        if (!Validator.isMobile(phone))
            throw new WebException(SystemErrors.PHONE_ILLEGAL);

        // 用户名
        String userName = sysUserDto.getUserName();
        // 查询
        SysUser sysUser = sysUserMapper.querySysUser(idNumber, userName);

        String userNo;
        SysUserVo sysUserVo;
        if (sysUser == null) {

            userNo = "U-" + IdUtil.fastSimpleUUID();
            SysUser newSysUser = new SysUser().setUserNo(userNo)
                    .setUserName(userName).setIdNumber(idNumber).setPhone(phone)
                    .setLastLoginTime(DateUtil.date());
            // 新增用户
            sysUserMapper.insert(newSysUser);
            // SysUser => SysUserVo
            sysUserVo = saTokenConverter.sysUser2SysUserVo(newSysUser);

        } else {

            userNo = sysUser.getUserNo();
            sysUser.setLastLoginTime(DateUtil.date());
            // 更新用户
            sysUserMapper.updateById(sysUser);
            // SysUser => SysUserVo
            sysUserVo = saTokenConverter.sysUser2SysUserVo(sysUser);
        }

        // TODO: 2023-12-16 生成token
        StpUtil.login(userNo);

        // TODO: 2023-12-20 缓存用户
        StpUtil.getSession().set(userNo, sysUserVo);

        return new ResponseWithEntities<SysUserVo>().setData(sysUserVo);
    }

    /**
     * 用户列表
     *
     * @return
     */
    @Override
    public ResponseWithEntities<List<SysUserVo>> sysUserList() {

        String userNo = (String) StpUtil.getLoginId();
        System.out.println("--------------" + userNo);

        List<SysUser> sysUserList = Optional.ofNullable(sysUserMapper.selectList(new QueryWrapper<SysUser>().eq("enable", 1)))
                .orElse(new ArrayList<>());
        // SysUser => SysUserVo
        List<SysUserVo> sysUserVos = saTokenConverter.sysUserList2SysUserVoList(sysUserList);
        return new ResponseWithEntities<List<SysUserVo>>().setData(sysUserVos);
    }

    /**
     * 当前用户信息
     *
     * @return
     */
    @Override
    public ResponseWithEntities<SysUserVo> getCurrentSysUser() {

        // 通过token获取userNo
        String userNo = (String) StpUtil.getLoginId();
        // 通过userNo获取redis中的对应的session
        SysUserVo sysUserVo = (SysUserVo) StpUtil.getSession().get(userNo);

        return new ResponseWithEntities<SysUserVo>().setData(sysUserVo);
    }
}
