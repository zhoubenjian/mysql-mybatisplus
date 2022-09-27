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
import java.util.Date;

/**
 * <p>
 * 州
 * </p>
 *
 * @author benjamin
 * @since 2022-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="State对象", description="州")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
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
    @TableField("`rank`")       // 关键字转义
    private Integer rank;

    @ApiModelProperty(value = "开始日期")
    private Date startTime;

    @ApiModelProperty(value = "结束日期")
    private Date endTime;

    @ApiModelProperty(value = "独立倾向, 0:不独立；1:独立")
    private Integer status;

    @ApiModelProperty(value = "代表人数")
    private Integer numberOfReps;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date updateTime;


}
