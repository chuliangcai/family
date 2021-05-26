package com.family.jdk.lang;

public class SuperDemo {

    public static void main(String[] args) throws ClassNotFoundException {
//        B a = new B();
//        a.hello();
        System.out.println(SuperDemo.f(2));
    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
//            value++;
            if (value == 2) {
                return 0;
            }
        }
    }

    static class A{
        private int a;
        public A(int a){

        }
    }
    static class B extends A{
        public B(){
            super(2);
        }
        public static void hello(){

        }
    }
}
