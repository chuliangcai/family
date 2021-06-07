package com.family.jdk.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
        try (FileChannel sourceChannel = new FileInputStream("/Users/chuyuancheng/Desktop/h.txt").getChannel();
             FileChannel targetChannel = new FileOutputStream("/Users/chuyuancheng/Desktop/h2.txt").getChannel();) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
//        Math.sqrt()
    }
}
