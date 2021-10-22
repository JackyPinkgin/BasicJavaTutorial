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

        String a1 = "youlo";
        String b1 = "you";
        String c1 = a1+b1;

        System.out.println(a1.compareTo(b1));

        int age =20 ;
        String name = "jacky";
        String info = String.format("my name is %s, age is %d",name,age);
        System.out.println(info);

        StringBuffer hello = new StringBuffer("hello");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(name);
        StringBuffer sheishuode = stringBuffer.append("sheishuode");
        System.out.println(stringBuffer);
        System.out.println(sheishuode);



    }


}
