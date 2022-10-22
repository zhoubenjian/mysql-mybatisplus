package com.benjamin.vo;

import com.benjamin.entities.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class OrderVo {

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "商品名")
    private String goodsName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "状态 0:待成交; 1:已成交; 2:已取消; 3:其他")
    private Integer status;

    @ApiModelProperty(value = "用户id")
    private Long userid;



    @ApiModelProperty(value = "用户")
    private User user;
}
