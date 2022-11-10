package com.benjamin.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("州查询")
public class StateRequest extends BasePageRequest {

    @ApiModelProperty(value = "开始日期")
    private String stateName;

    @ApiModelProperty(value = "开始日期")
    private String stateCapital;

    @ApiModelProperty(value = "州长")
    private String governor;
}
