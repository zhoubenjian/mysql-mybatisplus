package com.benjamin.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StudentReq extends BasePageRequest {

    @ApiModelProperty(value = "关键字")
    private String key;
}
