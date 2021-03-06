package com.family.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleDemoApplication implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SimpleDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        A a = (A) applicationContext.getBean("a");
        System.out.println("");
    }
}
