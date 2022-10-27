package com.benjamin.vo;

import com.benjamin.entities.President;
import com.benjamin.entities.State;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value="StatePresidentVo对象", description="StatePresidentVo对象")
public class StatePresidentVo extends State {

    @ApiModelProperty(value = "总统")
    private List<President> presidents;
}
