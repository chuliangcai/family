package com.family.spring.core;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryDemo {
    public interface Person {
        void eat();

        void sleep();
    }

    public static class Programmer implements Person {
        @Override
        public void eat() {
            System.out.println("吃饭");
        }

        @Override
        public void sleep() {
            System.out.println("睡觉");
        }

        public void code() {
            System.out.println("写代码");
        }
    }

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(new Programmer());
        proxyFactory.setInterfaces(Person.class);
        proxyFactory.addAdvice((MethodInterceptor) invocation -> {
            System.out.println("before");
            Object result = invocation.proceed();
            System.out.println("after");
            return result;
        });
        Programmer person = (Programmer) proxyFactory.getProxy();
        person.code();
    }
}
