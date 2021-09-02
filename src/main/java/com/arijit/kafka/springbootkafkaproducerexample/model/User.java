package com.arijit.kafka.springbootkafkaproducerexample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String dept;
    private Long salary;
}
