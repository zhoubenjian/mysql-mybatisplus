package com.benjamin.converter;

import com.benjamin.entities.Order;
import com.benjamin.entities.User;
import com.benjamin.vo.OrderVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiConverter {

    // Order => OrderVo
    OrderVo order2OrderVo(Order order, User user);
}
