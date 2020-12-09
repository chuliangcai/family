package com.jike.family.project.reactor;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactorDemoApplication {

    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(1000), Schedulers.newSingle("test")).subscribe(aLong -> {
            System.out.println(aLong + Thread.currentThread().getName());
        });
    }
}
