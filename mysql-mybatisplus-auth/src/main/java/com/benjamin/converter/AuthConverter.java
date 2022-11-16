package com.benjamin.converter;

import com.benjamin.entities.SysUser;
import com.benjamin.request.SysUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthConverter {

    /**
     * SysUserRequest => SysUser
     * @param sysUser
     * @param sysUserRequest
     */
    void sysUserRequest2SysUser(@MappingTarget SysUser sysUser, SysUserRequest sysUserRequest);
}
