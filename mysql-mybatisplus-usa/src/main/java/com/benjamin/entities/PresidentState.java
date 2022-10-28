package com.benjamin.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="PresidentState对象", description="PresidentState对象")
public class PresidentState extends President {

    @ApiModelProperty(value = "州")
    private State state;
}
