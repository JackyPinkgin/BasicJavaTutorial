package com.jacky.qqclient.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 2021/11/23
 * 该类，提供和消息相关的服务方法
 */
public class MessageClientService {

    public void sendMessageToAll(String content, String senderId){
        //构建 Message
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_TO_ALL_MES);//群发消息类型
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//发送时间设置到message对象
        System.out.println(senderId + " 对 大家 说 " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                                    .getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * content 内容
     * senderId 发送者userId
     * getterId 接收者userId
     */
    public void sendMessageToOne(String content, String senderId, String getterId) {
        //构建 Message
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//发送时间设置到message对象
        System.out.println(message.getSendTime()+" "+senderId + " 对 " + getterId + " 说 " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                                    .getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
