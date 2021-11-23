package com.jacky.qqclient.view;

import com.jacky.qqclient.service.FileClientService;
import com.jacky.qqclient.service.MessageClientService;
import com.jacky.qqclient.service.UserClientService;
import com.jacky.qqclient.utils.Utility;

import java.io.IOException;

/**
 * 2021/11/18
 */
public class QQView {

    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入
    private UserClientService userClientService = new UserClientService();//用于登录服务器/注册用户
    private MessageClientService messageClientService = new MessageClientService();//用于用户聊天
    private FileClientService fileClientService = new FileClientService();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new QQView().mainView();
        System.out.println("客户端退出系统");
    }


    //显示主菜单
    private void mainView() throws IOException, ClassNotFoundException {
        while (loop) {
            System.out.println("========欢迎登录网络通信系统========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);

            //根据用户输入来处理不同逻辑
            switch (key) {
                case "1":
//                    System.out.println("登录系统");
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    //需要到服务端验证该用户是否合法
                    if (userClientService.checkUser(userId, pwd)) {//先把逻辑打通
                        System.out.println("=========欢迎(用户 " + userId + "登录成功 )=======");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println("\n=========网络通信系统二级菜单(用户 " + userId + " )=======");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //这里老师准备写一个方法，来获取在线用户列表
                                    //System.out.println("显示在线用户列表");
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的话:");
                                    String s = Utility.readString(100);
                                    //调用方法，将消息封装成message对象后发给其他在线用户
                                    messageClientService.sendMessageToAll(s,userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号（在线）:");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话:(100字以内)");
                                    String content = Utility.readString(100);
                                    //编写一个方法，将消息发送给服务端
                                    messageClientService.sendMessageToOne(content,userId,getterId);
                                    break;
                                case "4":
                                    System.out.print("请输入你想把文件发送给的用户(在线用户)： ");
                                    getterId = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径(形式 d:\\xx.jpg)：");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入把文件发送到对应的路径(形式 d:\\yy.jpg)：");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    System.out.println("退出系统");
                                    break;
                                default:
                                    System.out.println("选择" + key + "错误");
                                    break;

                            }

                        }
                    } else { //登录服务器失败
                        System.out.println("=========登录失败=========");
                    }
                    break;
                case "9":
                    loop = false;
                    System.out.println("退出系统");
                    break;
            }
        }
    }
}
