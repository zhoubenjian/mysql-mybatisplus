package com.benjamin.converter;

import com.benjamin.entities.SysPermission;
import com.benjamin.vo.SysPermissionVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface SysConverter {

    @Mapping(target = "childList", ignore = true)
    void sysPermission2SysPermissionVo(@MappingTarget SysPermissionVo sysPermissionVo,
                                       SysPermission sysPermission);
}
