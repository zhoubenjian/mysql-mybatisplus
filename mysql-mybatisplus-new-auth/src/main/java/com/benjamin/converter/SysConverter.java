package com.benjamin.converter;

import com.benjamin.entities.SysPermission;
import com.benjamin.entities.SysRole;
import com.benjamin.request.SysPermissionReq;
import com.benjamin.vo.SysPermissionVo;
import com.benjamin.vo.SysRolePermissionVo;
import com.benjamin.vo.SysRoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface SysConverter {

    /**
     * SysPermissionReq => SysPermission
     *
     * @param sysPermission
     * @param sysPermissionReq
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enable", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    void sysPermissionReq2SysPermission(@MappingTarget SysPermission sysPermission,
                                        SysPermissionReq sysPermissionReq);

    /**
     * SysPermission => SysPermissionVo
     *
     * @param sysPermissionVo
     * @param sysPermission
     */
    @Mapping(target = "childList", ignore = true)
    void sysPermission2SysPermissionVo(@MappingTarget SysPermissionVo sysPermissionVo,
                                       SysPermission sysPermission);



    /**
     * SysRole => SysRoleVo
     *
     * @param sysRole
     * @return
     */
    SysRoleVo sysRole2SysRoleVo(SysRole sysRole);
    List<SysRoleVo> sysRoleList2SysRoleVoList(List<SysRole> list);

    /**
     * SysRoleVo => SysRole
     *
     * @param sysRole
     * @param sysRoleVo
     */
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    void sysRoleVo2SysRole(@MappingTarget SysRole sysRole,
                           SysRoleVo sysRoleVo);

    /**
     * (SysRoleVo + List<SysPermissionVo>) => SysRolePermissionVo
     *
     * @param sysRolePermissionVo
     * @param sysRoleVo
     * @param sysPermissionVos
     */
    void combineSysRolePermissionVo(@MappingTarget SysRolePermissionVo sysRolePermissionVo,
                                    SysRoleVo sysRoleVo,
                                    List<SysPermissionVo> sysPermissionVos);
}
