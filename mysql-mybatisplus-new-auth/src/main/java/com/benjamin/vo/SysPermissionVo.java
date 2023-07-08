package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value="权限返回对象", description="权限返回对象")
public class SysPermissionVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "父级权限id")
    private Long parentId;

    @ApiModelProperty(value = "权限名")
    private String permissionName;

    @ApiModelProperty(value = "权限描述")
    private String permissionDesc;

    @ApiModelProperty(value = "权限规则")
    private String permissionUrl;

    @ApiModelProperty(value = "权限类型")
    private String permissionType;

    @ApiModelProperty(value = "是否可用, 0:不可用；1:可用（默认）")
    private Integer enable;



    @ApiModelProperty(value = "子权限")
    private List<SysPermissionVo> childList;
}
