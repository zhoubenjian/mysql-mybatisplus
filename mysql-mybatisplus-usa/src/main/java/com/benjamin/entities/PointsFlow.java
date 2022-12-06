package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 积分流水表
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PointsFlow对象", description="积分流水表")
public class PointsFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "总统id")
    private Long presidentId;

    @ApiModelProperty(value = "政党id")
    private Long partyId;

    @ApiModelProperty(value = "州id")
    private Long stateId;

    @ApiModelProperty(value = "积分")
    private Long points;

    @ApiModelProperty(value = "方式, 1:签到/签退；2:手动添加；3:其他")
    @TableField(value = "`type`")
    private Integer type;

    @ApiModelProperty(value = "是否可用, 1:可用；2:不可用")
    private Integer enable;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date updateTime;


}
