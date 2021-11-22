package com.jacky.qqclient.service;

import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;
import com.jacky.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 2021/11/19
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {

    private User u = new User();

    //因为Socket在其他地方也可能使用，因此作出属性
    private Socket socket;

    //根据userId和pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) throws IOException, ClassNotFoundException {
        boolean b = false;

        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        //链接到服务端，发送u对象
        socket = new Socket(InetAddress.getLocalHost(), 9999);
        //得到ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u);//发送User对象

        //读取从服务端回复的message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();

        if (ms.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {//接口默认是public static final

            //创建一个和服务器端保持通信的线程->创建一个类，ClientConnectServerThread
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            //启动客户端的线程
            clientConnectServerThread.start();
            //为了后面客户端的扩展，将线程放入集合中管理
            ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
            b =true;

        } else {
            //如果登录失败,就不能启动通信线程，要关闭Socket
            socket.close();
        }
        return b;

    }

    //向服务器端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message， 类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_GET_ONLINE_FRIEND);

        //发送给服务器
        try {
            //得到当前线程socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            //发送一个Message对象，向服务端要求在线用户列表
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
