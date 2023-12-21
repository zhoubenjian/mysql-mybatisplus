package com.benjamin.dao;

import com.benjamin.entities.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2023-12-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 用户信息
     *
     * @param idNumber  身份证号
     * @param userName  手机号
     * @return
     */
    SysUser querySysUser(@Param("idNumber") String idNumber,
                         @Param("userName") String userName);
}
