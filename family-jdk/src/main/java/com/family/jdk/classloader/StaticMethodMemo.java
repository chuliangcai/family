package com.family.jdk.classloader;

public class StaticMethodMemo {

    public static void main(String[] args) {

        String a = Test_B.str;
    }
    public static class Test_A{
        public static String str= "str_A";
        static {
            System.out.println("static A");
        }
    }
    public static class Test_B extends Test_A{
        static {
            System.out.println("static B");
        }
    }
}
