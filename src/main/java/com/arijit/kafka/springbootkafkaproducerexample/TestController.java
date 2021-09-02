package com.arijit.kafka.springbootkafkaproducerexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class TestController {

    @GetMapping("/test")
    public String testMethod(){
        return "Application is working";
    }
}
