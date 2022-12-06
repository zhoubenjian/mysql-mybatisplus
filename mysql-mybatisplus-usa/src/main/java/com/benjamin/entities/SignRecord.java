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
 * 签到记录表
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SignRecord对象", description="签到记录表")
public class SignRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "总统id")
    private Long presidentId;

    @ApiModelProperty(value = "状态, 1:签到；2:签退")
    private Integer status;

    @ApiModelProperty(value = "是否可用, 1:可用；2:不可用")
    private Integer enable;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.DEFAULT)
    private Date updateTime;


}
