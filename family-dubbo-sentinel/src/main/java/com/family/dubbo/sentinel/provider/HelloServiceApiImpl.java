package com.family.dubbo.sentinel.provider;

import org.apache.dubbo.config.annotation.DubboService;

import com.family.dubbo.sentinel.api.HelloServiceApi;

@DubboService
public class HelloServiceApiImpl implements HelloServiceApi {

    @Override
    public String hi() {
        return "hello world";
    }
}
