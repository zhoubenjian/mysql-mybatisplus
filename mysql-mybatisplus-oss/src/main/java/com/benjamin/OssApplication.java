package com.benjamin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)     // 忽略数据库配置
@MapperScan("com.benjamin.dao")
public class OssApplication {
    public static void main(String[] args) {

        SpringApplication.run(OssApplication.class, args);
    }
}
