package com.family.spring.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserRequest {

    @Autowired
    private UserService userService;

    //模拟用户请求
    @Scheduled(fixedDelay = 2000)
    public void hi() {
        String msg = userService.hi();
        System.out.println(msg);
    }
}
