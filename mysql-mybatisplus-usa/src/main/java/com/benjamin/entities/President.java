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
 * 总统
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Data
@ApiModel(value="President对象", description="总统")
public class President implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String president_name;

    @ApiModelProperty(value = "性别,0:女；1:男")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "出生地")
    private String birth_place;

    @ApiModelProperty(value = "逝世日期")
    private Date deathday;

    @ApiModelProperty(value = "逝世地")
    private String location_of_death;

    @ApiModelProperty(value = "是否在世, 0:去世；1:在世")
    private Integer is_alive;

    @ApiModelProperty(value = "届数")
    private String term_of_office;

    @ApiModelProperty(value = "任期开始日期")
    private Date term_start_time;

    @ApiModelProperty(value = "任期结束日期")
    private Date term_end_time;

    @ApiModelProperty(value = "是否跳跃任期, 0:无；1:有")
    private Integer is_skip_term;

    @ApiModelProperty(value = "二次任期开始日期")
    private Date other_term_start_time;

    @ApiModelProperty(value = "二次任期结束日期")
    private Date other_term_end_time;

    @ApiModelProperty(value = "如何结束，-1:其他，0:辞职，1:正常卸任，2:卒于任上")
    private Integer type;

    @ApiModelProperty(value = "党派")
    private Long party_id;

    @ApiModelProperty(value = "州名")
    private Long state_id;

    @ApiModelProperty(value = "是否在任, 0:卸任；1:在任")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty(value = "修改时间")
    private Date update_time;
}
