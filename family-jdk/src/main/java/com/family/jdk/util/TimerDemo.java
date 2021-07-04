package com.family.jdk.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class TimerDemo {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        CountDownLatch latch = new CountDownLatch(1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是一个延迟任务1");
                latch.countDown();
                //timer.cancel();
            }
        }, 1000 * 100);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是一个延迟任务2");
                latch.countDown();
                //timer.cancel();
            }
        }, 1000 * 200);
        latch.await();
    }
}
