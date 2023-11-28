package com.benjamin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class PresidentVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String presidentName;

    @ApiModelProperty(value = "性别,0:女；1:男")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "出生地")
    private String birthPlace;

    @ApiModelProperty(value = "逝世日期")
    private LocalDate deathday;

    @ApiModelProperty(value = "逝世地")
    private String locationOfDeath;

    @ApiModelProperty(value = "是否在世, 0:去世；1:在世")
    private Integer isAlive;

    @ApiModelProperty(value = "届数")
    private String termOfOffice;

    @ApiModelProperty(value = "任期开始日期")
    private LocalDate termStartDate;

    @ApiModelProperty(value = "任期结束日期")
    private LocalDate termEndDate;

    @ApiModelProperty(value = "如何结束，-1:其他，0:辞职，1:正常卸任，2:卒于任上")
    private Integer type;

    @ApiModelProperty(value = "党派")
    private Long partyId;

    @ApiModelProperty(value = "州名")
    private Long stateId;

    @ApiModelProperty(value = "是否在任, 0:卸任；1:在任")
    private Integer status;



    @ApiModelProperty(value = "年龄")
    private Integer age;
}
