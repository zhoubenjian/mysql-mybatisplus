package com.benjamin.controller;

import com.benjamin.response.ResponseWithEntities;
import com.benjamin.sercice.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqController {

    @Autowired
    private RabbitmqService rabbitmqService;



    @PostMapping("/send/{message}")
    public ResponseWithEntities<String> sendMessage(@PathVariable("message") String message) {
        return rabbitmqService.sendMessage(message);
    }
}
