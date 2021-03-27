package com.family.jdk.gc;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  当eden区域没有空间足够空间分配新对象时就会发生minor gc
 */
public class MinorGcDemoApplication {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现一次Minor GC
        System.out.println("before gc");
        allocation4 = new byte[4 * _1MB];
    }
}
