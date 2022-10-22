package com.benjamin.client;

import com.benjamin.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")        // user注册的服务名称
public interface UserClient {

    @GetMapping("user/{userId}")
    User queryUserByUserId(@PathVariable("userId") Long userId);
}
