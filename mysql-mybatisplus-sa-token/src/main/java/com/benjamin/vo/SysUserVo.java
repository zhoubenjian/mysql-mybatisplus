package com.benjamin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class SysUserVo {

    @ApiModelProperty(value = "用户编号")
    private String userNo;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "最近登录时间")
    private Date lastLoginTime;
}
