package com.family.spring.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {
    public interface Calculator {
        int add(int a, int b);
        int subtract(int a, int b);
    }
    public static class CalculatorImpl implements Calculator {
        @Override
        public int add(int a, int b) {
            return a + b;
        }
        @Override
        public int subtract(int a, int b) {
            return a - b;
        }
    }
    public static class ProxyFactory implements InvocationHandler {
        private final Calculator real;
        public ProxyFactory(Calculator real) {
            this.real = real;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            Object result = method.invoke(real, args);
            System.out.println("after");
            return result;
        }
    }
    public static void main(String[] args) {
        Calculator real = new CalculatorImpl();
        ProxyFactory proxyFactory = new ProxyFactory(real);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(real.getClass().getClassLoader(), new Class[]{Calculator.class}, proxyFactory);
        System.out.println(proxy.add(1, 2));
        System.out.println(proxy.subtract(2, 1));
    }
}
