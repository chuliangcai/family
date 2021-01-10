package com.jike.family.project.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ReactorDemoApplication {

    public static void main(String[] args) throws Exception {
        testPublishOn();

        //        Flux.just(1,2).
    }

    public static void testPublishOn() throws Exception {
        Scheduler s = Schedulers.elastic();
        Flux
                .range(1, 1000)
                .map(i -> {
                    System.out.println("first map thread:" + Thread.currentThread().getName()+ "id" + Thread.currentThread().getId());
                    return 10 + i;
                })
                .map(i -> {
                    System.out.println("second map thread:" + Thread.currentThread().getName()+ "id" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "value " + i;
                }).subscribeOn(Schedulers.elastic()).subscribe(t -> {
            System.out.println(t + " thread:" + Thread.currentThread().getName() + "id" + Thread.currentThread().getId());
        });

        /*Thread x = new Thread(() -> flux.subscribe(t -> {
            System.out.println(t + " thread:" + Thread.currentThread().getName());
        }));
        x.start();*/
        System.in.read();
    }
}
