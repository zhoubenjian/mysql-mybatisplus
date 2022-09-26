package com.benjamin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class StateVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "州名")
    private String state_name;

    @ApiModelProperty(value = "首府")
    private String state_capital;

    @ApiModelProperty(value = "州长")
    private String governor;

    @ApiModelProperty(value = "党派，0：摇摆州")
    private Long party_id;

    @ApiModelProperty(value = "缩写")
    private String abbreviation;

    @ApiModelProperty(value = "经济排名")
    private Integer rank;

    @ApiModelProperty(value = "开始日期")
    private Date start_time;

    @ApiModelProperty(value = "结束日期")
    private Date end_time;

    @ApiModelProperty(value = "独立倾向, 0:不独立；1:独立")
    private Integer status;

    @ApiModelProperty(value = "代表人数")
    private Integer number_of_reps;
}
