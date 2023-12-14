package com.benjamin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RabbitmqApplication {

    public static void main(String[] args) {

        SpringApplication.run(RabbitmqApplication.class, args);
    }
}
