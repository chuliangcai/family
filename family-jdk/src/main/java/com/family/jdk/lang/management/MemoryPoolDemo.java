package com.family.jdk.lang.management;

import java.util.concurrent.locks.LockSupport;

public class MemoryPoolDemo {
    public static void main(String[] args) throws Exception{
        LockSupport.park();
    }

    public void test(){
        int a=10;
        int b=11;
        double bc=10;
    }
}
