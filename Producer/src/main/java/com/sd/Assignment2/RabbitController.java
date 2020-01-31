package com.sd.Assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    private Producer producer;

    @Autowired
    public RabbitController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public String sendMessage(){
        producer.produceMsg();
        return "Successfully Msg Sent";
    }
}
