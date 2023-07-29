package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2023-07-22
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 角色列表
     *
     * @param enable    可用（默认：true）
     * @return
     */
    List<SysRole> sysRoleList(@Param("enable") Boolean enable);

    /**
     * 获取权限Id
     *
     * @param roleName
     * @return
     */
    Long sysRoleByRoleName(@Param("roleName") String roleName);

    /**
     * 角色名是否存在
     *
     * @param roleName
     * @return
     */
    int roleNameExist(@Param("roleName") String roleName);

    /**
     * 批量删除/恢复 角色（逻辑）
     *
     * @param roleIds   主键
     * @param enable    是否可用, 0:不可用；1:可用（默认）
     * @return
     */
    int resetSysRolesByIds(@Param("roleIds") List<Long> roleIds,
                           @Param("enable") Integer enable);
}
