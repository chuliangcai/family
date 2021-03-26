package com.family.jdk.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FutureTaskDemoApplication {

    public static void main(String[] args) throws Exception {

        List<String> results = new ArrayList<>();
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " supplyAsync");
            return "Hello ";
        }).thenApplyAsync(v -> {
            System.out.println(Thread.currentThread().getName() + " thenApplyAsync");
            return v + "world";
        }).thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(Thread.currentThread().getName() + " accept");
                results.add(s);
            }
        });
        System.out.println(results);

    }

    interface Callback {
        void handle();
    }

    public void asyncExecute(Callback callback) {
        callback.handle();
    }
}
