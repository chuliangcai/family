package com.family.spring.boot;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class A {

    @PostConstruct
    public void init() {
        System.out.println("初始化原型bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁原型bean");
    }

}
