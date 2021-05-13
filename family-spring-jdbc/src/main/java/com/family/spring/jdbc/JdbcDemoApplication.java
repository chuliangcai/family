package com.family.spring.jdbc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.family.spring.jdbc.domain.model.Coffee;
import com.family.spring.jdbc.domain.repository.CoffeeRepository;

@SpringBootApplication
public class JdbcDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        Coffee coffee = new Coffee();
        coffee.setName("拿铁");
        coffee.setPrice(BigDecimal.valueOf(30));
        coffeeRepository.save(coffee);
    }
}
