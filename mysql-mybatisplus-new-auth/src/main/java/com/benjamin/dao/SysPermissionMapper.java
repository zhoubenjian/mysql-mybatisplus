package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 所有权限
     *
     * @return
     */
    List<SysPermission> allPermissions();

    /**
     * 同一parentId下，权限名是否已存在
     *
     * @param parentId          父级权限id
     * @param permissionName    权限名
     * @return
     */
    int permissionNameExistWithParentId(@Param("parentId") Long parentId,
                                        @Param("permissionName") String permissionName);
}
