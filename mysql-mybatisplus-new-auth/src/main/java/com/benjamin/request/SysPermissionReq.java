package com.benjamin.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@ApiModel(value = "权限Req")
public class SysPermissionReq {

    @NotBlank(message = "父级权限id不能为空")
    @ApiModelProperty(value = "父级权限id")
    private Long parentId;

    @NotBlank(message = "权限名不能为空")
    @ApiModelProperty(value = "权限名")
    private String permissionName;

    @NotBlank(message = "权限描述不能为空")
    @ApiModelProperty(value = "权限描述")
    private String permissionDesc;

    @ApiModelProperty(value = "权限规则")
    private String permissionUrl;

    @NotNull(message = "权限类型不能为空")
    @ApiModelProperty(value = "权限类型")
    private Integer permissionType;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
