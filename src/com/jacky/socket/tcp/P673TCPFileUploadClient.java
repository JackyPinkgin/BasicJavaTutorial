package com.jacky.socket.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;

/**
 * 2021/11/15
 */
public class P673TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        String filePath = "src/bg.png";
        File file = new File(filePath);
        byte[] buff;
        int readLen1 = 0;

        //先使用bufferedInputStream来读取图片文件的内容到字节流里
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //使用工具类的方法处理成byte数组
        buff = StreamUtils.streamToByteArray(bis);

        //链接到服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //使用缓存输出流  输出byte数组的内容到socket
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(buff);

        //关闭不必要的流
        bis.close();
        socket.shutdownOutput();

        //使用BufferReader来读取输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //反正这个题只会有一行输入，我就读取一行；对比内容是正确的就直接关闭相关的流然后退出
        String s = bufferedReader.readLine();
        System.out.println(s);
        if (Objects.equals(s, "收到图片")) {
            System.out.println("收到图片确认，客户端退出");
            socket.shutdownInput();
            bufferedReader.close();
        }else {
            System.out.println("内容错误哦");
        }

        bos.close();
        socket.close();
        System.out.println("客户端退出");


    }
}
