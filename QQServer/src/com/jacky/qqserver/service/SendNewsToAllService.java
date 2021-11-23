package com.jacky.qqserver.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;
import com.jacky.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 2021/11/23
 */
public class SendNewsToAllService implements Runnable {

    @Override
    public void run() {
        //为了可以推送多次，使用while循环
        while (true) {
            System.out.println("请输入服务器要推送的消息，输入exit表示退出推送服务");
            String news = Utility.readString(100);
            if ("exit".equals(news)){
                break;
            }
            //构建一个消息  群发消息
            Message message = new Message();
            message.setMsgType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人 : " + news);

            //遍历当前所有通信线程，得到socket，并发送message对象
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineUserId = iterator.next().toString();
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
