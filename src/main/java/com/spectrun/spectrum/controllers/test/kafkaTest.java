package com.spectrun.spectrum.controllers.test;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class kafkaTest {
    static record messageComp(String message){

    }

    private KafkaTemplate<String,String> kafkaTemplate;

    public kafkaTest(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/testMessage")
    public String sendTestMessage(@RequestBody messageComp m){
        kafkaTemplate.send("create_instance",m.message);
        return "sent";
    }

}
