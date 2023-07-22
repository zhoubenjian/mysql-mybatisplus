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
 * @since 2023-07-08
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

    /**
     * 修改角色
     *
     * @param id        主键
     * @param roleName  角色名
     * @param roleDesc  角色描述
     * @param enable    是否可用, 0:不可用；1:可用（默认）
     * @param sort      排序, 0:默认
     * @return
     */
    int updateSysRoleById(@Param("id") Long id,
                          @Param("roleName") String roleName,
                          @Param("roleDesc") String roleDesc,
                          @Param("enable") Integer enable,
                          @Param("sort") Integer sort);
}
