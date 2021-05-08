package com.family.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopDemoApplication implements ApplicationRunner {
    @Autowired
    private ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(SpringAopDemoApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.login();
        userService.register();
    }
}
