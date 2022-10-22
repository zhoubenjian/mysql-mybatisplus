package com.benjamin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjamin.client.UserClient;
import com.benjamin.converter.ApiConverter;
import com.benjamin.entities.Order;
import com.benjamin.dao.OrderMapper;
import com.benjamin.entities.User;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ApiConverter apiConverter;



    /**
     * 根据orderId查询order
     * @param orderId
     * @return
     */
    @Override
    public ResponseWithEntities<OrderVo> queryOrderByOrderId(Long orderId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        Order order = orderMapper.selectOne(queryWrapper);

        // 使用feign远程调用
        User user = userClient.queryUserByUserId(order.getUserid());

        OrderVo orderVo = apiConverter.order2OrderVo(order, user);

        return new ResponseWithEntities<OrderVo>().setData(orderVo);
    }
}
