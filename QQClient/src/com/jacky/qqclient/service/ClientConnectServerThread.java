package com.jacky.qqclient.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 2021/11/19
 */
public class ClientConnectServerThread extends Thread {

    //该线程需要持有Socket
    private Socket socket;

    //构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台和服务器通信，因此我们while循环
        while (true) {
            System.out.println("客户端线程，等待读取从服务端发送的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                //message后续处理
                //判断message类型，做对应的业务处理
                //如果读取到的是服务端返回的在线用户列表
                if (message.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息，并显示
                    //规定message的content里的名字，都用【空格】隔开
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n=======当前在线用户列表=======");
                    for (String onlineUser : onlineUsers) {
                        System.out.println("用户：" + onlineUser);
                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //把服务器转发来的消息显示到控制台即可
                    //System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() + " 说 " + message.getContent());
                    System.out.println("\n" + message.getSendTime() + " " + message.getSender() + " 对 " +
                            message.getGetter() + " 说 " + message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //显示在我们客户端的控制台
                    System.out.println("\n" + message.getSender() + " 对大家说 " + message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MES)) {//如果是文件消息
                    System.out.println("\n" + message.getSender() + " 给 " + message.getGetter()
                            + " 发文件 " + message.getSrc() + " 到 我电脑的目录 " + message.getDest());

                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n文件保存成功~");
                } else {
                    System.out.println("是其他类型的messageType，暂时不处理");
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
