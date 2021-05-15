package com.family.jdk.lang;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "will end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("main thread will end");
    }
}
