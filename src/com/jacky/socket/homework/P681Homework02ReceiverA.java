package com.jacky.socket.homework;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * 2021/11/16
 * 这里的向回发送是有问题的
 */
public class P681Homework02ReceiverA {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(9996);
        System.out.println("接收方准备好了");
        String answer = "";
        byte[] data = new byte[1024];
        DatagramPacket packetReceive = new DatagramPacket(data, data.length);

        datagramSocket.receive(packetReceive);

        String s = new String(packetReceive.getData(),0,packetReceive.getLength());
        System.out.println(s);
        if (s.equals("四大名著是哪些")) {
            answer =  "四大名著是《红楼梦》等";
        }else {
            answer = "what?";
        }
        byte[] outData = answer.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outData,
                0, outData.length, InetAddress.getLocalHost(), 9995);

        datagramSocket.send(outPacket);

        datagramSocket.close();
        System.out.println("A退出");
    }
}
