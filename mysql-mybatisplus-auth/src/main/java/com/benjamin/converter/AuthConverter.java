package com.benjamin.converter;

import com.benjamin.entities.SysUser;
import com.benjamin.request.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthConverter {

    /**
     * SysUserRequest => SysUser
     * @param sysUser
     * @param sysUserReq
     */
    void sysUserRequest2SysUser(@MappingTarget SysUser sysUser, SysUserReq sysUserReq);
}
