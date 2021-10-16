package com.jacky.codeblock;

import javax.swing.*;

public class Practice {
    public static void main(String[] args) {
        Test a = new Test();
        Singleton b = Singleton.getInstance();
        System.out.println(b.getName());


    }
}

//单例模式
class Singleton{

    private String name;

    private Singleton(String name) {
        this.name = name;
    }

    private static Singleton s = new Singleton("Mary");

    public static Singleton getInstance(){
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Sample{

    Sample(String s) {
        System.out.println(s);//1  "静态成员sam初始化"     3 "sam1 成员初始化"
    }

    Sample() {
        System.out.println("Sample的无参构造器被调用");
    }
}

class Test {
    Sample sam1 = new Sample("sam1 成员初始化");
    static Sample sam = new Sample("静态成员sam初始化");

    static {
        System.out.println("static块执行"); // 2
        if (sam == null) {
            System.out.println("sam is null");
        }
    }

    Test() {
        //普通代码块和普通属性初始化
        System.out.println("Test默认构造器被调用");  //4
    }
}
