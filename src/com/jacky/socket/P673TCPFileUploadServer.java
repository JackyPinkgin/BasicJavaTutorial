package com.jacky.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2021/11/15
 */
public class P673TCPFileUploadServer {
    public static void main(String[] args) throws Exception {


        String savePath = "src/bg_new.png";

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端启动，在9999端口监听");
        Socket socket = serverSocket.accept();
        //用一个bufferedInputStream获取收到的字节流，然后用StreamUtils类的方法处理成byte数组
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //用bufferedOutputStream来输出byte数组的内容到文件中
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));
        bos.write(bytes);
        bos.close();

        //重新用bufferedWriter去输出内容给socket
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        //必须要flush，bufferedWriter才会刷新内容到管道中
        writer.flush();
        socket.shutdownOutput();

        //关闭一些流和管道
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();


    }
}
