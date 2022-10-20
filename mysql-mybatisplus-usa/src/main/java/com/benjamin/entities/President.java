package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 总统
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="President对象", description="总统")
public class President implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "是否跳跃任期, 0:无；1:有")
    private Integer isSkipTerm;

    @ApiModelProperty(value = "二次任期开始日期")
    private Date otherTermStartDate;

    @ApiModelProperty(value = "二次任期结束日期")
    private Date otherTermEndDate;

    @ApiModelProperty(value = "如何结束，-1:其他，0:辞职，1:正常卸任，2:卒于任上")
    private Integer type;

    @ApiModelProperty(value = "党派")
    private Long partyId;

    @ApiModelProperty(value = "州名")
    private Long stateId;

    @ApiModelProperty(value = "是否在任, 0:卸任；1:在任")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date updateTime;



    @ApiModelProperty(value = "州")
    private State state;
}
