package com.jacky.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2021/11/15
 * 字符流实现
 */
public class P671SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待连接");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String s = bufferedReader.readLine();
        System.out.println(s);

//        String line = "";
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("hello,client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        bufferedWriter.close();
        bufferedReader.close();
//        socket.shutdownOutput();
        System.out.println("服务端关闭输出流");
//        socket.shutdownInput();
        System.out.println("服务端关闭输入流");


    }
}
