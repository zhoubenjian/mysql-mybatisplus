package com.benjamin.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@ApiModel(value = "角色Req")
public class SysRoleReq {

    @NotBlank(message = "角色名不能为空")
    @ApiModelProperty(value = "角色名")
    private String roleName;

    @NotBlank(message = "角色描述不能为空")
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "排序, 0:默认")
    private Integer sort;
}
