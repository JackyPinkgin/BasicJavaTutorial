package com.jacky.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * 2021/11/12
 */
public class P669SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket = "+socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        outputStream.write("你好，服务器".getBytes());
        //需要设置结束标记
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        byte[] buffClient = new byte[1024];
        int readLen = 0;
        while ((readLen=inputStream.read(buffClient))!=-1){
            System.out.println(new String(buffClient, 0, readLen));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出了");

    }
}
