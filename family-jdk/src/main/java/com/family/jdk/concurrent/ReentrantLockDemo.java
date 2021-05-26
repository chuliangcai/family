package com.family.jdk.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static volatile int i = 1;
    private static volatile int ai = 0;
    private static final int a1 = 10;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition1 = reentrantLock.newCondition();
    private static Condition condition2 = reentrantLock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                printAi1();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                printAi2();
            }
        }).start();
        reentrantLock.getQueueLength();
        LockSupport.park();
    }

    public static void printAi2() {
        reentrantLock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            ai = a1 + i * 7;
            System.out.println(Thread.currentThread().getName() + ": a" + i + "=" + ai);
            condition1.signal();
            condition2.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void printAi1() {
        reentrantLock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            ai = a1 + i * 7;
            System.out.println(Thread.currentThread().getName() + ": a" + i + "=" + ai);
            condition2.signal();
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
