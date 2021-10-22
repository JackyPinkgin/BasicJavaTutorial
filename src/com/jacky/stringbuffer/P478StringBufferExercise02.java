package com.jacky.stringbuffer;

import java.util.Scanner;

/**
 * 2021/10/21
 */
public class P478StringBufferExercise02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input a price");
        double price1 = scanner.nextDouble();

        System.out.println(price1);

        String  price = String.valueOf(price1);
        StringBuffer sb = new StringBuffer(price);

        for (int i = sb.lastIndexOf(".")-3; i>0 ; i-=3) {
            sb = sb.insert(i,",");
        }

        System.out.println(sb);
    }
}
