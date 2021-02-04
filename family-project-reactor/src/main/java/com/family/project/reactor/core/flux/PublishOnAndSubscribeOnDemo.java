package com.family.project.reactor.core.flux;

import java.util.concurrent.locks.LockSupport;

import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class PublishOnAndSubscribeOnDemo {
    public static void main(String[] args) {
Flux.fromIterable(Lists.newArrayList("A", "B"))
        .map(t -> {
            System.out.println(Thread.currentThread().getName() + "first");
            return t.toLowerCase();
        })
        .subscribeOn(Schedulers.single())
        .map(t -> {
            System.out.println(Thread.currentThread().getName() + "second");
            return "prefix" + t;
        })
        .publishOn(Schedulers.boundedElastic())
        .map(t -> {
            System.out.println(Thread.currentThread().getName() + "third");
            return t + "suffix";
        })
        .subscribe();
LockSupport.park();
    }
}
