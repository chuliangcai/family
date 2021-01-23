package com.family.project.reactor.core.flux;

import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;

public class FluxOperatorDemoApplication {

    public static void main(String[] args) {
        //testMap();
    }

    public static void testMap() {
        Flux<String> flux1 = Flux.fromIterable(Lists.newArrayList("A", "B"));
        flux1.map(i -> i.toLowerCase()).subscribe((s) -> {
            System.out.println(s);
        });
    }
}
