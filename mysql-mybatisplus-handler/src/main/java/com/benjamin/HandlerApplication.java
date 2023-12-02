package com.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.benjamin.dao")     // 扫描指定路径下的*mapper
public class HandlerApplication {

    public static void main(String[] args) {

        SpringApplication.run(HandlerApplication.class, args);
    }
}
