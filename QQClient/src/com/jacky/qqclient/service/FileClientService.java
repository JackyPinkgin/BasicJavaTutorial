package com.jacky.qqclient.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;

import java.io.*;

/**
 * 2021/11/23
 * 该类完成文件传输服务
 */
public class FileClientService {

    public void sendFileToOne(String src,String dest, String senderId, String getterId){
        //读取src文件-->message

        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //读取文件
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            //将文件对应字节数组设置到message
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //提示信息
        System.out.println("\n" + senderId + " 给 " + getterId + " 发送文件：" + src + " 到对方的电脑目录 " + dest);
        //发送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                            .getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
