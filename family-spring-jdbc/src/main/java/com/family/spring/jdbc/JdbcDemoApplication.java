package com.family.spring.jdbc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.family.spring.jdbc.domain.model.Coffee;
import com.family.spring.jdbc.domain.repository.CoffeeRepository;
import com.family.spring.jdbc.domain.service.CoffeeService;

@SpringBootApplication
public class JdbcDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            coffeeService.save(new Coffee("拿铁", BigDecimal.valueOf(10)), new Coffee("美式", BigDecimal.valueOf(20)));
        } catch (Exception e) {
            System.out.println(coffeeRepository.findAll());
        }
    }
}
