package com.family.jdk.sun.misc;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

import sun.misc.Unsafe;

public class UnsafeDemo {
    private static Unsafe unsafe;

    public static void main(String[] args) throws Exception {
        LockSupport.park();
    }

    public static void testGetByte() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        unsafe = (Unsafe) field.get(null);
        long a = unsafe.allocateMemory(8);
        unsafe.putLong(a, 0x0102030405060708L);
        byte b = unsafe.getByte(a);
        System.out.println(Integer.toHexString(b & 0xFF));
    }
}
