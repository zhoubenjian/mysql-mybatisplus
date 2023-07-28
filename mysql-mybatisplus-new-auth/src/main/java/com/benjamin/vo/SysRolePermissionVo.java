package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "角色权限对象")
public class SysRolePermissionVo extends SysRoleVo {

    @ApiModelProperty(value = "权限")
    private List<SysPermissionVo> sysPermissionVos;
}
