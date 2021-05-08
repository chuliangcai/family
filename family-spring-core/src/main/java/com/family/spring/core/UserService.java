package com.family.spring.core;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    void login() throws Exception {
        Thread.sleep(1000);
    }

    void register() throws Exception {
        Thread.sleep(2000);
    }
}
