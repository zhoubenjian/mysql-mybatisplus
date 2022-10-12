package com.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.benjamin.dao")     // 扫描指定路径下的*mapper
public class UsaApplication {
    public static void main(String[] args) {

        SpringApplication.run(UsaApplication.class, args);
    }
}
