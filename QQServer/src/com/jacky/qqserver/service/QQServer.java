package com.jacky.qqserver.service;



import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;
import com.jacky.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2021/11/22
 * 这是服务器，在监听9999，等待客户端连接并保持通讯
 * 11/22 P693
 */
public class QQServer {

    private ServerSocket ss = null;
    //创建一个集合来存放多个用户，如果是这些用户登录，就认为是合法
    //这里可以试用ConcurrentHashMap，可以处理并发的集合，没有线程安全问题
    //HashMap没有处理线程安全，因此在多线程情况下不安全
    //ConCurrentHashMap处理了线程安全，即线程同步处理，在多线程情况下安全
    private static HashMap<String, User> validUsers = new HashMap<>();
//    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ArrayList<Message>> offlineMessage = new ConcurrentHashMap<>();

    static {//在静态代码块，初始化ValidUsers
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("Jacky", new User("Jacky", "123456"));
    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId, String passwd) {
        User user = validUsers.get(userId);
        if (user == null) {//说明userid没有存在validUser的key中
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {//userId正确但是passwd错误
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            System.out.println("服务端在9999端口监听");
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();

            ss = new ServerSocket(9999);
            while (true) {//当和某个客户端建立连接后，会继续监听，因此使用while循环
                Socket socket = ss.accept();

                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();
                //得到socket关联对象的输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //创建一个Message对象，准备回复客户端
                Message message = new Message();

                //验证用户信息
                if (checkUser(u.getUserId(), u.getPasswd())) {//合法
                    //目前先写死对应user的账户密码，后面再加入校验逻辑
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将Message对象回复
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有该socket对象
                    ServerConnectClientThread serverConnectClientThread
                            = new ServerConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    serverConnectClientThread.start();
                    //将该线程放入一个集合中进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);

                } else {//登录失败
                    System.out.println("用户id " + u.getUserId() + " pwd " + u.getPasswd() + " 验证失败");
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //登录失败后，要关闭socket
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务器退出了while，说明服务端不再监听，因此关闭serverSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
