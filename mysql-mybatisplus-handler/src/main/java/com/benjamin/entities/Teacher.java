package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 教师
 * </p>
 *
 * @author benjamin
 * @since 2023-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Teacher对象", description="教师")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "编号")
    private String teacherNo;

    @ApiModelProperty(value = "姓名")
    private String teacherName;

    @ApiModelProperty(value = "性别	 1:男；2:女")
    private Integer gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "身份证号(加密)")
    private String idNumber;

    @ApiModelProperty(value = "身份证号(加密)")
    private String phone;

    @ApiModelProperty(value = "是否班主任 0:不是；1:是")
    private Integer isReal;

    @ApiModelProperty(value = "课程编号")
    private Integer courseId;

    @ApiModelProperty(value = "0:不可用(冻结)；1:可用")
    private Integer enable;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
