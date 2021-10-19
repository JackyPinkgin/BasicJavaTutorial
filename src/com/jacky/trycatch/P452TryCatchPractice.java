package com.jacky.trycatch;

import java.util.Scanner;

public class P452TryCatchPractice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");

        int i;
        while (true) {
            try {
                i = scanner.nextInt();
                break;
            } catch (Exception e) {
//            e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("请重新输入");
                scanner.next();
            }
        }
        System.out.println("你输入的整数是：" + i);

        System.out.println("learn new things about git");


    }
}
