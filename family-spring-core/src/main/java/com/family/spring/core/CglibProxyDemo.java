package com.family.spring.core;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyDemo {
    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
    }

    public static class CalculatorInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before add");
            Object o1 = methodProxy.invokeSuper(o, objects);
            System.out.println("after add");
            return o1;
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Calculator.class);
        enhancer.setCallback(new CalculatorInterceptor());
        Calculator calculator = (Calculator) enhancer.create();
        System.out.println(calculator.add(1, 2));
    }
}
