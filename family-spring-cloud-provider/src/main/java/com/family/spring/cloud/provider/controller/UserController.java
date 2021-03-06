package com.family.spring.cloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private PortListener portListener;

    @GetMapping("/hi")
    public String hi() {
        return "hello world from " + portListener.getServerPort();
    }
}
