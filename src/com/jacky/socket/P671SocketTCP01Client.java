package com.jacky.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 2021/11/15
 * 字符流实现
 */
public class P671SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接启动");

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("hello server 字符流 ");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束；注意，要求对方使用readLine()!!!
        bufferedWriter.flush();//如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
//        socket.shutdownOutput();
        System.out.println("客户端关闭输出流");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

//        String line  ="";
//        while ((line = bufferedReader.readLine())!=null){
//            System.out.println(line);
//        }

        bufferedReader.close();
        bufferedWriter.close();
//        socket.shutdownInput();
        System.out.println("客户端关闭输入流");


    }
}
