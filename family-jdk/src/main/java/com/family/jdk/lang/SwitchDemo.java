package com.family.jdk.lang;

public class SwitchDemo {
    public static void main(String[] args) {
        String a = args[0];
        switch (a) {
            case "a":
                System.out.println("case 1");
                break;
            case "b":
                System.out.println("case 2");
                break;
            default:
                System.out.println("other");
        }
    }
}
