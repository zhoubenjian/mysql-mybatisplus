package com.benjamin.sercice.impl;

import com.benjamin.date.DateToolUtil;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.sercice.RabbitmqService;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RabbitmqServiceImpl implements RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;



    @Override
    public ResponseWithEntities<String> sendMessage(String queueName) {

        RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitTemplate);

        // 如果queueName队列不存在
        if (Objects.isNull(rabbitAdmin.getQueueProperties(queueName)))
            return new ResponseWithEntities<String>().setData(queueName + " 队列不存在");

        rabbitTemplate.convertAndSend(queueName, "Today is " + DateToolUtil.getDateStr(DateToolUtil.HH_MM_SS));
        return new ResponseWithEntities<String>().setData("向 " + queueName + " 队列发送成功成功！");
    }
}
