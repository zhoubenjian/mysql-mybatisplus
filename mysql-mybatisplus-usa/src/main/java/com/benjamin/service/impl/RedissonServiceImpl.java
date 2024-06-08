package com.benjamin.service.impl;

import com.benjamin.redis.RedissonUtil;
import com.benjamin.service.RedissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedissonServiceImpl implements RedissonService {

    @Autowired
    private RedissonUtil redissonUtil;

    private Integer tickets = 100;



    @Override
    public void ticketSell() {

        Boolean tryLock = false;
        tryLock = redissonUtil.tryLock("TICKET", 120, 10);

        try {
            if (!tryLock)
                throw new RuntimeException("其他订单正在操作！");

            if (tickets == 0)
                throw new RuntimeException("库存不足...");

            System.out.println(Thread.currentThread().getName() + ", 购得第：" + tickets + "票！");
            tickets--;

        } finally {

            if (tryLock) {
                // 释放锁
                redissonUtil.unlock("TICKET");
            }
        }
    }
}
