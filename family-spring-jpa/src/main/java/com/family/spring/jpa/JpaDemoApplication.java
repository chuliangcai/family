package com.family.spring.jpa;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.family.spring.jpa.service.CoffeeOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class JpaDemoApplication implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CoffeeOrderService coffeeOrderService = (CoffeeOrderService) applicationContext.getBean("coffeeOrderService");
        coffeeOrderService.order("拿铁", BigDecimal.valueOf(30), "12311111111");
        System.out.println("ddd");
    }
}
