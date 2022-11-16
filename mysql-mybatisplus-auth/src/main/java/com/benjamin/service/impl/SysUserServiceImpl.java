package com.benjamin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjamin.constant.EncryptionConstant;
import com.benjamin.converter.AuthConverter;
import com.benjamin.entities.SysUser;
import com.benjamin.dao.SysUserMapper;
import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.random.Randoms;
import com.benjamin.request.SysUserRequest;
import com.benjamin.response.BaseResponse;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.utils.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private AuthConverter authConverter;



    @Override
    public BaseResponse insertSysUer(SysUserRequest sysUserRequest) {
        String userName = sysUserRequest.getUserName();
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName).eq("locked", 1);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        // 用户不存在
        if (sysUser != null) {
            return new BaseResponse()
                    .setCode(-1L)
                    .setStatus(-1L)
                    .setMessage("用户已存在")
                    .setView("用户已存在");
        }

        SysUser su = new SysUser();
        // SysUserRequest => SysUser
        authConverter.sysUserRequest2SysUser(su, sysUserRequest);

        String pwd = sysUserRequest.getPassword();
        // 随机盐值
        String salt  = Randoms.randomString(19);
        // 密码加密
        String password = ShiroUtil.getEncryptionPassword(salt, pwd);
        su.setPassword(password).setSalt(salt);

        // 写入数据库
        sysUserMapper.insert(su);

        return new BaseResponse().setView(userName + "添加成功").setMessage(userName + "添加成功");
    }

    @Override
    public BaseResponse login(SysUserRequest sysUserRequest) {
        String userName = sysUserRequest.getUserName();
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName).eq("locked", 1);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        // 用户不存在
        if (sysUser == null) {
            return new BaseResponse()
                    .setCode(-2L)
                    .setStatus(-2L)
                    .setMessage("用户名或密码错误")
                    .setView("用户名或密码错误");
        }

        String salt = sysUser.getSalt();
        String password = ShiroUtil.getEncryptionPassword(salt, sysUserRequest.getPassword());
        if (!password.equals(sysUser.getPassword())) {
            return new BaseResponse()
                    .setCode(-3L)
                    .setStatus(-3L)
                    .setMessage("用户名或密码错误")
                    .setView("用户名或密码错误");
        }

        // TODO: 2022-11-17 颁发token，并添加至请求头

        return new BaseResponse().setView(userName + "登录成功").setMessage(userName + "登录成功");
    }
}
