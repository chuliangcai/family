package com.family.jdk.lang;

public class SystemDemoApplication {

    public static void main(String[] args) {
        System.out.println(args);
        System.getenv().forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

        System.getProperties().forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }
}
