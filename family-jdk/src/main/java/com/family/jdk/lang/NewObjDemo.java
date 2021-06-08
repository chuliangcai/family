package com.family.jdk.lang;

import java.util.concurrent.locks.LockSupport;

public class NewObjDemo {
    public static class Test1{

    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Test1 test1=new Test1();
//        Class.forName()
        LockSupport.park();

    }
}
