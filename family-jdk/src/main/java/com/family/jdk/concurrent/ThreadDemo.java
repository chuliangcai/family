package com.family.jdk.concurrent;

import java.util.concurrent.locks.LockSupport;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           LockSupport.park();
            System.out.println("我被中断了");
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        LockSupport.park();
    }
}
