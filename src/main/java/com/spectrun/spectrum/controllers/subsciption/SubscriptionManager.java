package com.spectrun.spectrum.controllers.subsciption;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription/v1")
public class SubscriptionManager {
    private KafkaTemplate<String,String> kafkaTemplate;

    public SubscriptionManager(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }




}
