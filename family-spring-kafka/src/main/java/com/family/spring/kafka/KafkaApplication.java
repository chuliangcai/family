package com.family.spring.kafka;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class KafkaApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Autowired
    private OrderMessageService orderMessageService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        orderMessageService.sendOrder(new Order("123", BigDecimal.valueOf(20)));
        System.out.println("send success");
    }

    @Bean
    public RecordMessageConverter converter() {
        ObjectMapper mapper = new ObjectMapper();
        return new StringJsonMessageConverter(mapper);
    }
}
