package com.family.jdk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class FutureDemo {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 2, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executorService.allowCoreThreadTimeOut(true);
        //        executorService.set
        // 先让它涨起来。
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> 1);
        }
        LockSupport.park();
    }
}
