package com.family.jdk.io;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static class A{
        private int a;
    }

    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream output= new ObjectOutputStream(b);
        output.writeObject(new A());
        byte[] a = b.toByteArray();
        System.out.println("finish");
    }
}
