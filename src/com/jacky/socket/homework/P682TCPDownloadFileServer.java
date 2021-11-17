package com.jacky.socket.homework;

import com.jacky.socket.tcp.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2021/11/17
 */
public class P682TCPDownloadFileServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9993);
        System.out.println("服务端开始等待连接");
        Socket socket = serverSocket.accept();

        //读取客户端发过来的请求歌曲名称
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);
        String songname;

        if(s.equals("高山流水")){
            songname = "高山流水.mp3";
        }else {
            songname = "无名.mp3";
        }

        System.out.println(songname);

        String srcpath = "src/"+songname;
        //把输出的歌曲内容，用StreamUtils的方法转换成 byte[] 数组
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcpath));
        byte[] outSongData = StreamUtils.streamToByteArray(bufferedInputStream);

        System.out.println(srcpath + "歌曲已经转换成byte[]");

        //将数据输出
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(outSongData);

        System.out.println(srcpath + "歌曲已经发出");

        //关闭相关的流

        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        System.out.println("服务端关闭了");


    }
}
