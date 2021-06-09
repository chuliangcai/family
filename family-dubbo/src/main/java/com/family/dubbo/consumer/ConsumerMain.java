package com.family.dubbo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.family.dubbo.api.UserServiceApi;

@SpringBootApplication
public class ConsumerMain implements ApplicationRunner {

    @DubboReference
    private UserServiceApi userServiceApi;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userServiceApi.findTop20User();
        System.out.println("ssss");
    }
}
