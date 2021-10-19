package com.jacky.wrapper;

//包装类的测试


public class test {
    public static void main(String[] args) {

        Double d = Double.valueOf(100d);
        System.out.println(d);


        int a = 100;
        String str1 = Integer.toString(a);

        Integer integer = new Integer(str1);
        System.out.println(integer);

        String aa ="jacky";
        System.out.println(aa.intern());


    }


}
