package com.family.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageService {

    @Autowired
    private KafkaTemplate<String, Order> orderKafkaTemplate;

    public void sendOrder(Order order) {
        orderKafkaTemplate.send("cloud.orders.topic", order);
    }
}
