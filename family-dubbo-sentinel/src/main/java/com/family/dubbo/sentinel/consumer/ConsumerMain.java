package com.family.dubbo.sentinel.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.family.dubbo.sentinel.api.HelloServiceApi;

@SpringBootApplication
public class ConsumerMain implements ApplicationRunner {

    @DubboReference
    private HelloServiceApi helloServiceApi;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 13; i++) {
            executorService.execute(() -> {
                helloServiceApi.hi();
            });
        }
    }
}
