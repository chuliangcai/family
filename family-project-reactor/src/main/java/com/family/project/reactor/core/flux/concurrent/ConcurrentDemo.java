package com.family.project.reactor.core.flux.concurrent;

import java.time.Duration;
import java.util.concurrent.locks.LockSupport;

import com.google.common.collect.Lists;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ConcurrentDemo {

    public static class User {
        private int id;

        public User(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) throws Exception {
        Mono<String> mono = Mono.just("SUCCESS").delayElement(Duration.ofSeconds(3));
        mono.subscribe((s) -> {
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(mono.block());
    }
}
