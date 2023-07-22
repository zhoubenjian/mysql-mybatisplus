package com.benjamin.dao;

import com.benjamin.entities.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * 角色名是否存在
     *
     * @param roleName
     * @return
     */
    int roleNameExist(@Param("roleName") String roleName);

}
