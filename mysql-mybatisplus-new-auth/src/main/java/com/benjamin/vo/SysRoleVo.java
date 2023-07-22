package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

@Data
@Accessors(chain = true)
@ApiModel(value = "角色Vo")
public class SysRoleVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @Range(min = 0, max = 1, message = "enable值非法")
    @ApiModelProperty(value = "是否可用, 0:不可用；1:可用（默认）")
    private Integer enable;

    @Min(value = 0, message = "sort值非法")
    @ApiModelProperty(value = "排序, 0:默认")
    private Integer sort;
}
