package com.jacky.qqserver.service;

import com.jacky.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2021/11/23
 * 用来在用户登录时遍历离线信息，检查是否有对应的userId的信息，打包成message发送给对应的userid
 */
public class OfflineMsgSend extends Thread {

    private String userId;
    private Socket socket;

    public OfflineMsgSend(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    @Override
    public void run() {
        //检查HashMap中是否有对应userId的信息
        ConcurrentHashMap<String, ArrayList<Message>> offlineMessage = QQServer.getOfflineMessage();
        if (true) {//写写成true
            ArrayList<Message> messages = offlineMessage.get(userId);

            //获取输出流
            try {
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());

                Iterator<Message> iterator = messages.iterator();
                while (iterator.hasNext()){
                    Message msg = iterator.next();
                    System.out.println(msg.getContent());
                    oos.writeObject(msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

