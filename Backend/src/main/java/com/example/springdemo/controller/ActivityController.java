package com.example.springdemo.controller;

import com.example.springdemo.dto.CustomMessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ActivityController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public ActivityController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/sensor")
    @SendTo("/topic/sensor")
    public void send(CustomMessageView message){
        this.simpMessagingTemplate.convertAndSend("/topic/sensor", message);
    }

}
