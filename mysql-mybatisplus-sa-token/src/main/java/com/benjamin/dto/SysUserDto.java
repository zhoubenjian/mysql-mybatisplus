package com.benjamin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class SysUserDto {

    @NotBlank(message = "用户名不能为空")
    @Size(message = "用户名长度须介于2位-20位", min = 2, max = 20)
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @NotBlank(message = "身份证号不能为空")
    @Length(message = "身份证号长度须18位", min = 18, max = 18)
    @ApiModelProperty(value = "身份证号", required = true)
    private String idNumber;

    @NotBlank(message = "手机号不能为空")
    @Length(message = "手机号长度须11位", min = 11, max = 11)
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
}
