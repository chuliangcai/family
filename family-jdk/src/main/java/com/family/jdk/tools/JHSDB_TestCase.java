package com.family.jdk.tools;

public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点

        }
    }

    private static class ObjectHolder {}

    public static void main(String[] args) throws Exception {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
        System.in.read();
    }
}
