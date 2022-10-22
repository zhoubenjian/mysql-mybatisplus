package com.benjamin.controller;

import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.OrderService;
import com.benjamin.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    /**
     * 根据orderId查询order
     * @param orderId
     * @return
     */
    @GetMapping("{orderId}")
    public ResponseWithEntities<OrderVo> queryOrderByOrderId(@PathVariable Long orderId) {
        return orderService.queryOrderByOrderId(orderId);
    }
}

