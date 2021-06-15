package com.family.alibaba.transmittablethreadlocal;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

public class TransmittableThreadLocalDemo {
    public static final TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        context.set("value-set-in-parent");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable task = new RunnableTask();
        executorService.execute(Objects.requireNonNull(TtlRunnable.get(task)));
        executorService.shutdown();
    }

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println(context.get());
        }
    }
}
