package com.family.dubbo.sentinel.provider;

import java.util.Random;

import org.apache.dubbo.config.annotation.DubboService;

import com.family.dubbo.sentinel.api.HelloServiceApi;

@DubboService
public class HelloServiceApiImpl implements HelloServiceApi {

    @Override
    public String hi() {
        int m = new Random().nextInt(20);
        try {
            System.out.println(200+m);
            Thread.sleep(200+m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world";
    }
}
