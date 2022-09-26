package com.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.benjamin.dao")
public class USAApplication {
    public static void main(String[] args) {

        SpringApplication.run(USAApplication.class, args);
    }
}
