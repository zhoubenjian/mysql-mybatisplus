package com.benjamin.service.impl;

import com.benjamin.converter.SysConverter;
import com.benjamin.entities.SysRole;
import com.benjamin.dao.SysRoleMapper;
import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.request.SysRoleReq;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2023-07-22
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysConverter sysConverter;



    /**
     * 角色列表（不分页）
     *
     * @param enable    可用（默认：true）
     * @return
     */
    @Override
    public ResponseWithEntities<List<SysRoleVo>> sysRoleList(Boolean enable) {

        List<SysRole> sysRoleList = sysRoleMapper.sysRoleList(enable);
        // SysRole => SysRoleVo
        List<SysRoleVo> sysRoleVos = sysConverter.sysRoleList2SysRoleVoList(sysRoleList);

        return new ResponseWithEntities<List<SysRoleVo>>().setData(sysRoleVos);
    }

    /**
     * 添加角色
     *
     * @param sysRoleReq
     * @return
     */
    @Override
    public ResponseWithEntities<String> addSysRole(SysRoleReq sysRoleReq) {

        String roleName = sysRoleReq.getRoleName();
        String roleDesc = sysRoleReq.getRoleDesc();
        Integer sort = sysRoleReq.getSort();

        // 角色名是否已存在
        if (sysRoleMapper.roleNameExist(roleName) == 1)
            throw new WebException(SystemErrors.ROLE_ALREADY_EXIST);

        synchronized (this) {

            SysRole sysRole = new SysRole().setRoleName(roleName).setRoleDesc(roleDesc).setSort(sort);
            // 添加
            sysRoleMapper.insert(sysRole);

            return new ResponseWithEntities<String>().setData("角色：" + roleName + "，添加成功！");
        }
    }

    /**
     * 修改角色
     *
     * @param sysRoleVo
     * @return
     */
    @Override
    public ResponseWithEntities<String> updateSysRoleById(SysRoleVo sysRoleVo) {

        String roleName = sysRoleVo.getRoleName();

        // 角色名是否已存在
        if (sysRoleMapper.roleNameExist(roleName) == 1)
            throw new WebException(SystemErrors.ROLE_ALREADY_EXIST);

        SysRole sysRole = new SysRole();
        // SysRoleVo => SysRole
        sysConverter.sysRoleVo2SysRole(sysRole, sysRoleVo);
        // 修改
        sysRoleMapper.updateById(sysRole);

        return new ResponseWithEntities<String>().setData("角色：" + roleName + "，修改成功！");
    }
}
