package com.benjamin.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@ApiModel("总统查询")
public class PresidentRequest {

    @ApiModelProperty(value = "开始日期")
    private LocalDate startTime;

    @ApiModelProperty(value = "开始日期")
    private LocalDate endTime;
}
