package com.family.jdk.nio;

import java.nio.ByteBuffer;

public class DirectByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        buffer.putChar('a');
    }
}
