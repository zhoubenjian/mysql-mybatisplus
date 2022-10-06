package com.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.benjamin.dao")     // 扫描指定路径下的*mapper
public class USAApplication {
    public static void main(String[] args) {

        SpringApplication.run(USAApplication.class, args);
    }
}
