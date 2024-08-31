package com.spectrun.spectrum.controllers.subsciption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription/v1")
public class SubscriptionManager {
    @GetMapping("/test")
    public String testEndpoint(){
        return  "endpoint active";
    }
}
