package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="签到Vo对象", description="签到")
public class SignVo {

    @ApiModelProperty(value = "总统id")
    private Long presidentId;

    @ApiModelProperty(value = "描述")
    private String desc;
}
