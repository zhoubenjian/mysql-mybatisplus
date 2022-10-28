package com.benjamin.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value="StatePresident对象", description="StatePresident对象")
public class StatePresident extends State {

    @ApiModelProperty(value = "总统")
    private List<President> presidents;
}
