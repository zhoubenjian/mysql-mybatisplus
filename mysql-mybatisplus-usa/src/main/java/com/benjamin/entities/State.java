package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 州
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Data
@ApiModel(value="State对象", description="州")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty(value = "修改时间")
    private Date update_time;
}
