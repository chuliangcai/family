package com.family.dubbo.sentinel.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.family.dubbo.sentinel.api.HelloServiceApi;
import com.family.dubbo.sentinel.api.Sms;
import com.family.dubbo.sentinel.api.SmsSendServiceApi;
import com.google.common.collect.Lists;

@SpringBootApplication
public class ConsumerMain implements ApplicationRunner {

    @DubboReference
    private HelloServiceApi helloServiceApi;

    @DubboReference
    private SmsSendServiceApi smsSendServiceApi;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.execute(() -> {
            while (true) {
                helloServiceApi.hi();
            }
        });
        executorService.execute(() -> {
            while (true) {
                smsSendServiceApi.send(Lists.newArrayList(new Sms("123", "haha"), new Sms("456", "kkk")));
            }
        });

    }
}
