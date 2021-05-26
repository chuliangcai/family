package com.family.jdk.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：我阻塞了");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + ": 我被唤醒了");
        });
        thread.start();
        Thread.sleep(2000);
        LockSupport.unpark(thread);
    }
}
