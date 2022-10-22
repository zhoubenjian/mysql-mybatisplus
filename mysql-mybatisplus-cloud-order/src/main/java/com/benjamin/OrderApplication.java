package com.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients             // feign客户端（feign继承了ribben，实现了负载均衡）
@MapperScan("com.benjamin.dao")
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class, args);
    }
}
