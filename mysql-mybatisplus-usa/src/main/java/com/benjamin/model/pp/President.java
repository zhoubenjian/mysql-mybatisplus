package com.benjamin.model.pp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="President 简单对象", description="President 简单对象")
public class President {

    @ApiModelProperty(value = "id（主键）")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String presidentName;
}
