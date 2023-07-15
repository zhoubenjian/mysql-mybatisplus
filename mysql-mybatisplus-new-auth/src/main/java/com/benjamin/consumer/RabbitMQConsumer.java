package com.benjamin.consumer;

import com.benjamin.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RabbitMQ消费者
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMqConfig.QUEUE_NAME))
public class RabbitMQConsumer {

    /**
     * 当前环境
     */
    @Value("${spring.profiles.active}")
    private String env;



    @RabbitHandler
    public void process(List<String> stringList) {

        switch (this.env) {

            case "dev":
                System.out.println("--- 开发环境 ---");

            case "test":
                System.out.println("--- 测试环境 ---");

            case "prod":
                System.out.println("--- 正式环境 ---");
        }

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("消费者接收到的生产者消息" + i + ": " + stringList.get(i));
        }
    }
}
