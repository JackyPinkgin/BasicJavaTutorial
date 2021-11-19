package com.jacky.qqclient.service;

import java.util.HashMap;

/**
 * 2021/11/19
 * 该类管理客户端连接到服务器端的线程的类
 */
public class ManageClientConnectServerThread {
    //把多个线程放入HashMap集合，key就是用户Id，value就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }

    //通过userId，可以得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }

}
