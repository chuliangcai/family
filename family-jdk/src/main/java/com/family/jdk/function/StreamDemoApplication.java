package com.family.jdk.function;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class StreamDemoApplication {
    public static void main(String[] args) {
        List<String> letters = Lists.newArrayList("aa", "bb", "c");
        List<Character> characters = letters
                .stream()
                .map(t -> {
                    System.out.println("do something");
                    return t.charAt(1);
                })
                .collect(Collectors.toList());
    }
}
