package com.family.spring.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @Autowired
    private UserService userService;

    @GetMapping("hi")
    public String hi() {
        return userService.hi();
    }
}
