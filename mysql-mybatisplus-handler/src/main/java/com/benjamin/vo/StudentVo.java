package com.benjamin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="StudentVo对象", description="StudentVo对象")
public class StudentVo {

    @ApiModelProperty(value = "编号")
    private String studentNo;

    @ApiModelProperty(value = "姓名")
    private String studentName;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "年级编号")
    private Integer gradeId;

    @ApiModelProperty(value = "班级编号")
    private Integer classId;

    @ApiModelProperty(value = "班主任编号")
    private Integer teacherId;
}
