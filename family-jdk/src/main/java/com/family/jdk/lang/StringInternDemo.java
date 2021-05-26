package com.family.jdk.lang;

public class StringInternDemo {
    public static void main(String[] args) {
        //        String s0 = "kvill";
        //        String s1 = "kvill";
        //        String s2 = "kv" + "ill";
        final String str1 = "ja";
        final String str2 = "va";
        String str3 = str1 + str2;
        System.out.println(new String("java").intern() == str3);
        //        System.out.println(s0 == s1);
        //        System.out.println(s0 == s2);
        System.out.println("xxxx");
        Thread thread=new Thread();
        Thread.yield();
    }
}
