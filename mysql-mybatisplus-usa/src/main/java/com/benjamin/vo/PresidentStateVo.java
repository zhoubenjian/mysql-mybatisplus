package com.benjamin.vo;

import com.benjamin.entities.President;
import com.benjamin.entities.State;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="PresidentStateVo对象", description="PresidentStateVo对象")
public class PresidentStateVo extends President {

    @ApiModelProperty(value = "州")
    private State state;
}
