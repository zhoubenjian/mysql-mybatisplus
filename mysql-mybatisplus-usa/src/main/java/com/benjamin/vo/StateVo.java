package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value="State对象", description="州")
public class StateVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "州名")
    private String stateName;

    @ApiModelProperty(value = "首府")
    private String stateCapital;

    @ApiModelProperty(value = "州长")
    private String governor;

    @ApiModelProperty(value = "党派，0：摇摆州")
    private Long partyId;

    @ApiModelProperty(value = "缩写")
    private String abbreviation;

    @ApiModelProperty(value = "经济排名")
    private Integer rank;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "独立倾向, 0:不独立；1:独立")
    private Integer status;

    @ApiModelProperty(value = "代表人数")
    private Integer numberOfReps;
}
