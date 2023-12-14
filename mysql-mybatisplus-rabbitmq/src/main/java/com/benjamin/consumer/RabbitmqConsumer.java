package com.benjamin.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues =  "test-queue")
public class RabbitmqConsumer {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(RabbitmqConsumer.class);



    @RabbitHandler
    public void consumerMessage(String message) {
        logger.info("消息：" + message);
        System.out.println("消息：" + message);
    }
}
