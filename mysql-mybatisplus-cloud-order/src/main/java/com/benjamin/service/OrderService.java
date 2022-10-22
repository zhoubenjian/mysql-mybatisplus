package com.benjamin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.entities.Order;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.OrderVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-22
 */
public interface OrderService extends IService<Order> {

    /**
     * 根据orderId查询order
     * @param orderId
     * @return
     */
    ResponseWithEntities<OrderVo> queryOrderByOrderId(Long orderId);
}
