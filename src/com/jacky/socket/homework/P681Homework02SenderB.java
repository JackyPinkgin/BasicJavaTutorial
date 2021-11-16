package com.jacky.socket.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 2021/11/16
 */
public class P681Homework02SenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(9995);
        System.out.println("发送方开始");

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你的问题");
        String question = scanner.next();

        byte[] outData = question.getBytes();
        byte[] inData = new byte[1024];
        DatagramPacket packet = new DatagramPacket(outData, 0, outData.length, InetAddress.getLocalHost(), 9996);
        datagramSocket.send(packet);

        packet = new DatagramPacket(inData, inData.length);
        datagramSocket.receive(packet);
        String s = new String(packet.getData(), 0, packet.getLength());

        System.out.println(s);

        datagramSocket.close();

        System.out.println("B退出");


    }
}
