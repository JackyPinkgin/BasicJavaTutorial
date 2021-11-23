package com.jacky.qqserver.service;



import com.jacky.qqcommon.Message;
import com.jacky.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

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

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//这里线程处于run的状态，可以发送/接收消息
        while (true) {

            try {
                System.out.println("服务端和客户端" + userId + "保持通讯，读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message,根据message类型，做相应的业务处理
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {//客户端请求在线用户列表
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

                } else if (message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端退出的情况

                    System.out.println(message.getSender() + " 退出");
                    //将这个客户端对应的线程，从集合中删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    //退出while循环
                    break;
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)) {//发送普通的一对一消息
                    //根据message获取getterId，然后得到对应的线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //再得到对应的socket对象的输出流，将message对象转发给客户端
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//转发
                    // 【提示】：如果客户不在线，可以保存到数据库，实现离线留言
                } else if (message.getMsgType().equals(MessageType.MESSAGE_TO_ALL_MES)) {//发送消息到全员
                    //需要遍历管理线程的集合，把所有线程的socket得到，然后把message发送到对应的输出流里
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    //遍历hm
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户的id
                        String onLineUserId = iterator.next().toString();
                        if (!onLineUserId.equals(message.getSender())) {//排除群发消息的用户==排除给自己群发
                            //进行转发
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MES)) {//发送消息到全员

                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else {
                    System.out.println("其他类型的message，暂时不处理");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
