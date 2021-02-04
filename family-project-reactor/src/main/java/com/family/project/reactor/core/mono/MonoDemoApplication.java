package com.family.project.reactor.core.mono;

import java.time.Duration;
import java.util.concurrent.locks.LockSupport;

import reactor.core.publisher.Mono;

public class MonoDemoApplication {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("SUCCESS").delayElement(Duration.ofSeconds(3)).map(String::toLowerCase);
        mono.subscribe((str) -> {
            System.out.println("thread:" + Thread.currentThread().getName() + " element:" + str);
        });
        LockSupport.park();
    }
}
