package com.jacky.static_;

public class Hi {
    public static void main(String[] args) {

        Stu stu = new Stu("hi");
        Stu stu2 = new Stu("shei");
        System.out.println(Stu.a);


    }
}

class Stu {
    public static int fee = 0;
    static int a = 1;
    {
        System.out.println("第二个普通代码块");
    }

     {
        System.out.println("第一个普通代码块");
    }

    {
        System.out.println("第二个普通代码块");
    }

    private String name;

    public Stu(String name) {
        this.name = name;
    }

    public void pay(double fee) {
        Stu.fee += fee;
    }

    public static void show() {
        System.out.println(Stu.fee);
    }


}