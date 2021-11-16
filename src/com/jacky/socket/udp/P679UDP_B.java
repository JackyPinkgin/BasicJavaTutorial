package com.jacky.socket.udp;

import java.io.IOException;
import java.net.*;

/**
 * 2021/11/16
 */
public class P679UDP_B {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);
        System.out.println("B端启动");

        byte[] data = "hello,出来吃火锅".getBytes();

        DatagramPacket packet
                = new DatagramPacket(data, 0, data.length, InetAddress.getByName("10.114.69.91"), 9999);

        socket.send(packet);

        socket.receive(packet);
        String s = new String(packet.getData(),0, packet.getLength());
        System.out.println(s);


        socket.close();
        System.out.println("B端退出");


    }
}
