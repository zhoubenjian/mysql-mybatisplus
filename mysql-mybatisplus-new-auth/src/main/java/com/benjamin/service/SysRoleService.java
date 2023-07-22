package com.benjamin.service;

import com.benjamin.entities.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.request.SysRoleReq;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.SysRoleVo;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author benjamin
 * @since 2023-07-22
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 角色列表（不分页）
     *
     * @param enable    可用（默认：true）
     * @return
     */
    ResponseWithEntities<List<SysRoleVo>> sysRoleList(Boolean enable);

    /**
     * 添加角色
     *
     * @param sysRoleReq
     * @return
     */
    ResponseWithEntities<String> addSysRole(SysRoleReq sysRoleReq);

    /**
     * 修改角色
     *
     * @param sysRoleVo
     * @return
     */
    ResponseWithEntities<String> updateSysRoleById(SysRoleVo sysRoleVo);
}
