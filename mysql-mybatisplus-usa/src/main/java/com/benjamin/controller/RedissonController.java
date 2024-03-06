package com.benjamin.controller;

import com.benjamin.service.RedissonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "redisson测试", tags = {"redisson测试"})
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private RedissonService redissonService;



    @ApiOperation("售票")
    @GetMapping("/sell")
    public void ticketSell() {
        redissonService.ticketSell();
    }
}
