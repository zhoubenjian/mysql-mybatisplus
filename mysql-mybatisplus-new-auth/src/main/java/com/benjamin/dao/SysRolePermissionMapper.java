package com.benjamin.dao;

import com.benjamin.entities.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色_权限 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2023-07-22
 */
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    /**
     * 删除角色对应权限
     *
     * @param roleId    角色id
     * @return
     */
    int deleteByRoleId(@Param("roleId") Long roleId);

    /**
     * 修改角色对应权限（逻辑删除）
     *
     * @param roleIds   角色ids
     * @param enable    是否可用, 0:不可用；1:可用（默认）
     * @return
     */
    int updateByRoleIds(@Param("roleIds") List<Long> roleIds,
                        @Param("enable") Integer enable);
}
