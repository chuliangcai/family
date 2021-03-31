package com.family.jdk.gc;

import java.util.concurrent.locks.LockSupport;

public class DefaultGcInJava8Application {
    public static void main(String[] args) throws Exception {
        for (; ; ) {
            Thread.sleep(1);
        }
    }
}
