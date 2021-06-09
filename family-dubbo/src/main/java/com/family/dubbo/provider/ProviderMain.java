package com.family.dubbo.provider;

import java.util.concurrent.CountDownLatch;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProviderMain.class, args);
        new CountDownLatch(1).await();
    }
}
