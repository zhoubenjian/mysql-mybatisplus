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

/**
 * <p>
 * 用户
 * </p>
 *
 * @author benjamin
 * @since 2023-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysUser对象", description="用户")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "扩展字段1")
    private String f1;

    @ApiModelProperty(value = "扩展字段2")
    private String f2;

    @ApiModelProperty(value = "扩展字段3")
    private String f3;

    @ApiModelProperty(value = "扩展字段4")
    private String f4;

    @ApiModelProperty(value = "扩展字段5")
    private String f5;

    @ApiModelProperty(value = "扩展字段6")
    private String f6;

    @ApiModelProperty(value = "扩展字段7")
    private String f7;

    @ApiModelProperty(value = "是否可用, 0:冻结；1:可用（默认）")
    private Integer enable;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;


}
