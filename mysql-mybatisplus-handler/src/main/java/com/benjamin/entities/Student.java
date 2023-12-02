package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.benjamin.handler.AesTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "student", autoResultMap = true)
@ApiModel(value="Student对象", description="学生")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "编号")
    private String studentNo;

    @ApiModelProperty(value = "姓名")
    private String studentName;

    @ApiModelProperty(value = "性别	 1:男；2:女")
    private Integer gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "身份证号(加密)")
    @TableField(typeHandler = AesTypeHandler.class)
    private String idNumber;

    @ApiModelProperty(value = "手机号(加密)")
    @TableField(typeHandler = AesTypeHandler.class)
    private String phone;

    @ApiModelProperty(value = "年级编号")
    private Integer gradeId;

    @ApiModelProperty(value = "班级编号")
    private Integer classId;

    @ApiModelProperty(value = "班主任编号")
    private Integer teacherId;

    @ApiModelProperty(value = "0:不可用(冻结)；1:可用")
    private Integer enable;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
