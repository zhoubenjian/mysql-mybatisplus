package com.benjamin;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.benjamin.dao")     // 扫描指定路径下的*mapper
@EnableSwagger2Doc                  // 开启Swagger
@EnableWebMvc
public class USAApplication {
    public static void main(String[] args) {

        SpringApplication.run(USAApplication.class, args);
    }
}
