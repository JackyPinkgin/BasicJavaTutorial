package com.jacky.socket.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 2021/11/16
 */
public class P680Homework01Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9997);
        System.out.println("客户端启动");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你的问题");
        String question = scanner.next();

        String s ="";
        bufferedWriter.write(question);
        bufferedWriter.flush();
        socket.shutdownOutput();;
        s = bufferedReader.readLine();
        System.out.println(s);
//        bufferedWriter.write("hobby");
//        bufferedWriter.flush();
//        s = bufferedReader.readLine();
//        System.out.println(s);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();






    }
}
