package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.entities.SysPermission;

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
}
