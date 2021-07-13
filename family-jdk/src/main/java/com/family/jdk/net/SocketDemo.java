package com.family.jdk.net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(11111);
        Socket socket = serverSocket.accept();
        socket.setSoTimeout(1000 * 100);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[100];
        while (inputStream.read(bytes) != -1) {
            String a = new String(bytes);
            System.out.println(a);
        }
    }
}
