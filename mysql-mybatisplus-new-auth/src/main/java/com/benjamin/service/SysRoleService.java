package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.SysRole;
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
     * @param permissionIds 权限
     * @return
     */
    ResponseWithEntities<String> addSysRole(SysRoleReq sysRoleReq, List<Long> permissionIds);

    /**
     * 修改角色
     *
     * @param sysRoleVo
     * @param permissionIds 权限
     * @return
     */
    ResponseWithEntities<String> updateSysRoleById(SysRoleVo sysRoleVo, List<Long> permissionIds);

    /**
     * 批量删除/恢复 角色（逻辑）
     *
     * @param ids       主键
     * @param enable    是否可用, 0:不可用；1:可用（默认）
     * @return
     */
    ResponseWithEntities<String> resetSysRolesByIds(List<Long> ids, Integer enable);
}
