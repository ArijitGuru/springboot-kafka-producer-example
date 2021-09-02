package com.arijit.kafka.springbootkafkaproducerexample.resource;

import com.arijit.kafka.springbootkafkaproducerexample.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@Slf4j
public class UserResource {

    //For <String, String> key value, Kafkatemplate do not configuration
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    //For posting JSON, we need to configure the template
    @Autowired
    KafkaTemplate<String, User> kafkaTemplateJson;

    private static final String TOPIC = "Kafka_topic_example";

    @GetMapping("/publish/{message}")
    public String post (@PathVariable("message") final String message){
        log.info("Inside post method..");
        kafkaTemplate.send(TOPIC, message);
        log.info("Message logged!");
        return "Published String Successfully";

    }

    @GetMapping("/publishJson/{name}")
    public String postJson (@PathVariable("name") final String name){
        log.info("Inside postJson method..");
        kafkaTemplateJson.send(TOPIC, new User(name, "IT", 12000L));
        log.info("Message logged!");
        return "Published JSON Successfully";

    }

}
