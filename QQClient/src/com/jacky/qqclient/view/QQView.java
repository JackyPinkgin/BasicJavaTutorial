package com.jacky.qqclient.view;

import com.jacky.qqclient.utils.Utility;

/**
 * 2021/11/18
 */
public class QQView {

    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入

    public static void main(String[] args) {
        new QQView().mainView();
        System.out.println("客户端退出系统");
    }


    //显示主菜单
    private void mainView() {
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
                    if (true) {//先把逻辑打通
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
                                    System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
//                                    userClientService.logout();
                                    loop = false;
                                    System.out.println("退出系统");
                                    break;
                                default:
                                    System.out.println("选择"+key+"错误");
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
