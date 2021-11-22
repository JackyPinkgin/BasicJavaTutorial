package com.jacky.qqclient.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 2021/11/19
 */
public class ClientConnectServerThread extends Thread{

    //该线程需要持有Socket
    private Socket socket;

    //构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台和服务器通信，因此我们while循环
        while (true){
            System.out.println("客户端线程，等待读取从服务端发送的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                //message后续处理
                //判断message类型，做对应的业务处理
                //如果读取到的是服务端返回的在线用户列表
                if (message.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    //取出在线列表信息，并显示
                    //规定message的content里的名字，都用【空格】隔开
                    System.out.println(message.getContent());
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("=======当前在线用户列表=======");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }

                }else{
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
