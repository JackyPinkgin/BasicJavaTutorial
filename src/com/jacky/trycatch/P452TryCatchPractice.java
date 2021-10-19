package com.jacky.trycatch;

import java.util.Scanner;

public class P452TryCatchPractice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int i;
        String inputStr = "";
        while (true) {

                System.out.println("请输入一个整数");
                inputStr = scanner.next();
            try {
                i = Integer.parseInt(inputStr);
                break;
            } catch (Exception e) {
                System.out.println("你输入的不是整数");
            }
        }
        System.out.println("你输入的整数是：" + i);


    }
}
