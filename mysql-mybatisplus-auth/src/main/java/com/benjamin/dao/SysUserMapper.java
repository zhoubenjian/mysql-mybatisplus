package com.benjamin.dao;

import com.benjamin.entities.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2022-10-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 用户名查询用户
     * @param userName
     * @return
     */
    SysUser querySysUserByUserName(String userName);

    /**
     * 用户对于权限
     * @param userName
     * @return
     */
    List<String> queryPermissionsByUserName(@Param("userName") String userName);
}
