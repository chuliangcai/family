package com.family.netty;

import java.util.concurrent.TimeUnit;

import io.netty.util.HashedWheelTimer;

public class HashedWheelTimerDemo {
    public static void main(String[] args) {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(10, TimeUnit.MILLISECONDS);//512*10
        hashedWheelTimer.newTimeout(timeout -> System.out.println("我是一个延迟任务 from " + Thread.currentThread().getName()), 100, TimeUnit.SECONDS);
    }
}
