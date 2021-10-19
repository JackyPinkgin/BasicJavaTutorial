package com.jacky.trycatch;

public class P450TryCatchDetail {

    public static void main(String[] args) {

        try {
            String str = "123";
            String str1 = "Jacky";
            int a = Integer.parseInt(str1);
            System.out.println(a);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("异常信息：" + e.getMessage());
        }

    }
}
