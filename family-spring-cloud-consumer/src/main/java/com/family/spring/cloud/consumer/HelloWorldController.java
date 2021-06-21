package com.family.spring.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @Autowired
    private UserService userService;

    @GetMapping("hi")
    @HystrixCommand(fallbackMethod = "defaultHi")
    public String hi() {
        return userService.hi();
    }

    public String defaultHi() {
        return "hello world";
    }
}
