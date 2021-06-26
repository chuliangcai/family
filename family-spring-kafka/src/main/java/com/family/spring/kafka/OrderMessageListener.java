package com.family.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderMessageListener {

    @KafkaListener(topics = "cloud.orders.topic")
    public void handle(Order order) throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        String a = objectMapper.writeValueAsString(order);
        System.out.println(a);
    }
}
