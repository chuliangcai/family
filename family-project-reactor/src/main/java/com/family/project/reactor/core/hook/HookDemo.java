package com.family.project.reactor.core.hook;

import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.tools.agent.ReactorDebugAgent;

public class HookDemo {

    public static void main(String[] args) {
        ReactorDebugAgent.init();

        /*Flux.fromIterable(Lists.newArrayList("AA", "B"))
                .map(String::toLowerCase)
                .map(t -> t.charAt(1))
                .subscribe(System.out::println);*/

        Lists.newArrayList("AA", "B").stream().map(String::toLowerCase)
                .map(t -> {
                    System.out.println("sss");
                    return t.charAt(1);
                }).collect(Collectors.toList());
    }
}
