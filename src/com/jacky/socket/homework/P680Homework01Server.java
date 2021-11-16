package com.jacky.socket.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2021/11/16
 */
public class P680Homework01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9997);
        System.out.println("服务端启动");
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
            if (line.equals("name")) {
                bufferedWriter.write("Jacky");
            }else if (line.equals("hobby")) {
                bufferedWriter.write("编写Java程序");
            }else{
                bufferedWriter.write("你说啥呢");
            }
            bufferedWriter.flush();
        }


        //关闭对应的流
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();

    }
}
