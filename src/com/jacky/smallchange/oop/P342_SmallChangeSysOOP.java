package com.jacky.smallchange.oop;

/*
 * 该类是完成零钱通的各个功能的类
 * 要求使用面向对象编程
 *
 * */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class P342_SmallChangeSysOOP {

    //属性
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


    //先完成显示菜单，并可以选择
    public void mainMenu() {
        do {
            System.out.println("\n=============零钱通菜单(OOP)=============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退   出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            //使用switch分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        } while (loop);
    }

    //完成零钱通明细
    public void detail() {
        System.out.println(details);
    }

    //完成收益入账
    public void income(){
        System.out.println("收益入账金额:");
        money = scanner.nextDouble();
        //money的值范围应该校验
        //找出不正确的金额条件，然后给出提示，直接return
        if (money <= 0) {
            System.out.println("收益金额范围需要大于0");
            return;//退出方法，不再执行后面的代码
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额 " + balance;
    }

    //完成消费
    public void pay(){
        System.out.println("消费金额:");
        money = scanner.nextDouble();
        //消费范围校验
        if (money <= 0 || money > balance) {
            System.out.println("消费金额应该在0-" + balance);
            return;
        }
        System.out.println("消费说明：");
        note = scanner.next();
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额 " + balance;
    }

    //完成退出
    public void exit(){
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
    }
}
