package com.family.spring.cloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private Environment environment;

    @GetMapping("/hi")
    public String hi() {
        return "hello world from" + environment.getProperty("server.port");
    }
}
