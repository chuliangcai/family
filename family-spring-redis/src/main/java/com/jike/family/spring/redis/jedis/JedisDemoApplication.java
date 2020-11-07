package com.jike.family.spring.redis.jedis;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JedisDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JedisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("you are my honor");
    }
}
