package com.jacky.qqserver.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 2021/11/22
 * 该类的一个对象和某个客户端保持通讯
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;

    private String userId;//链接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {//这里线程处于run的状态，可以发送/接收消息
        while (true) {

            try {
                System.out.println("服务端和客户端" + userId + "保持通讯，读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message,根据message类型，做相应的业务处理
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    //客户端请求在线用户列表
                    /**
                     * 在线用户列表形式返回  100 200 300 Jacky
                     * */
                    System.out.println(message.getSender() + " 请求在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回Message，需要构建一个Message对象
                    Message message2 = new Message();
                    message2.setMsgType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //写入Socket，返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                }else {
                    System.out.println("其他类型的message，暂时不处理");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
