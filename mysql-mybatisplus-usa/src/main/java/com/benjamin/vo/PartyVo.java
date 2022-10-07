package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@ApiModel(value="Party对象", description="政党")
public class PartyVo {

    @ApiModelProperty(value = "名称")
    private String partyName;

    @ApiModelProperty(value = "创始人（,隔开）")
    private String founder;

    @ApiModelProperty(value = "开始日期")
    private LocalDate startDate;

    @ApiModelProperty(value = "结束日期")
    private LocalDate endDate;
}
