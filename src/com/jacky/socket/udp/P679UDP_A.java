package com.jacky.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 2021/11/16
 */
public class P679UDP_A {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);
        System.out.println("A端启动");
        byte[] buf = new byte[1024];
        byte[] data;
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);
        String s = new String(packet.getData(),0, packet.getLength());
        System.out.println(s);

        data = "好的，明天见".getBytes();
        packet = new DatagramPacket(data,0,data.length,
                InetAddress.getByName("10.114.69.91"),9998);
        socket.send(packet);

        socket.close();
        System.out.println("A端退出");

    }
}
