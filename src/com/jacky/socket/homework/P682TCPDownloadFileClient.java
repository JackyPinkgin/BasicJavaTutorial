package com.jacky.socket.homework;

import com.jacky.socket.tcp.StreamUtils;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 2021/11/17
 *
 * 客户端输入一个音乐文件名称，比如高山流水，服务端收到音乐名后，可以给客户端返回这个音乐文件，如果服务器么有这个文件，返回一个默认的音乐
 * 客户端收到文件后，保存在本地e:\\
 */
public class P682TCPDownloadFileClient {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要的音乐");

        String songName = scanner.nextLine();
        System.out.println(songName);

        Socket socket = new Socket(InetAddress.getLocalHost(), 9993);

        //将songName用字符流输出
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(songName);
        bufferedWriter.flush();
        //bufferedWriter.newLine();//这一行好像没有用，需要明确知道到底是什么用的
        socket.shutdownOutput();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] songData = StreamUtils.streamToByteArray(bufferedInputStream);

        String songPath = "d:/"+songName+".mp3";
        BufferedOutputStream songOutputStream = new BufferedOutputStream(new FileOutputStream(songPath));
        songOutputStream.write(songData);

        System.out.println("歌曲文件"+songName+".mp3  已经写入目录");

        songOutputStream.close();
        bufferedWriter.close();

        socket.close();
        System.out.println("客户端关闭了");


    }
}
