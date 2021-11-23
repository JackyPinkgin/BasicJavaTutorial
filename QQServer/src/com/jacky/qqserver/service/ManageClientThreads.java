package com.jacky.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 2021/11/22
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到hm集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    //根据userId返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //增加一个从集合中移除某个线程对象
    public static void removeServerConnectClientThread(String userId) {
        if (hm.get(userId) != null) {
            hm.remove(userId);
        }else {
            System.out.println(userId + " 对应的线程不存在");
        }
    }

    //这里编写方法，可以返回在线用户列表
    public static String getOnlineUser() {
        String onlineUserList = "";
        //集合遍历，遍历HashMap的key
        Set<String> names = hm.keySet();
        for (String name : names) {
            onlineUserList += name + " ";
        }
        return onlineUserList;
    }

}
