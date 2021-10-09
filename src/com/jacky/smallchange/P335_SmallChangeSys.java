package com.jacky.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class P335_SmallChangeSys {
    //1.先完成显示菜单，并可以选择菜单，给出对应菜单


    public static void main(String[] args) {

        //定义相关变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细
        String details = "---------------零钱通明细---------------";

        //3.完成收益入账
        //定义新的变量
        double money = 0;
        double balance = 0;
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化

        //4.消费
        String note = null;
        String check = null;
        char out;

        do {
            System.out.println("\n=============零钱通菜单=============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退   出");

            System.out.println("请选择(1-4):");
            key = scanner.next();


            //使用switch分支控制
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额:");
                    money = scanner.nextDouble();
                    //money的值范围应该校验
                    //找出不正确的金额条件，然后给出提示，直接break
                    if (money <= 0) {
                        System.out.println("收益金额范围需要大于0");
                        break;
                    }
                    balance += money;
                    date = new Date();
//                    System.out.println(sdf.format(date));
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额 " + balance;
//                    System.out.println(details);
                    break;
                case "3":
                    System.out.println("消费金额:");
                    money = scanner.nextDouble();
                    //消费范围校验
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额应该在0-" + balance);
                        break;
                    }
                    System.out.println("消费说明：");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额 " + balance;
                    break;
                case "4":
                    String choice = "";
                    while (true) {
                        System.out.println("确认退出吗?y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        } else {
                            System.out.println("必须输入y/n");
                        }
                    }
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        } while (loop);

        System.out.println("----退出了零钱通----");
    }


}
