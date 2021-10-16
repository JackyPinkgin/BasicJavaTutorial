package com.jacky.innerclass;

import javax.security.auth.login.CredentialNotFoundException;

public class P420P421 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.shuchu();

        //外部其他类，使用成员内部类的三种方式
        //第一种方式
        Outer08.Inner08 inner = outer08.new Inner08();
        inner.say();
        System.out.println(inner.family);
        System.out.println("===============");
        //第二种方式  在外部类中，写一个方法，可以返回一个inner对象
        Outer08.Inner08 inner1 = outer08.getInner08Instance();
        inner1.say();
        //第三种方式
        Outer08.Inner08 inner3 = new Outer08().new Inner08();
    }
}

class Outer08 {
    private int n1 = 10;
    public String name = "jacky";

    //内部类可以访问外部类的所有成员，包括私有的
    class Inner08 {
        public String family = "yiqi";
        int n1 = 66;

        public void say() {
            System.out.println("n1 = " + n1 + " name is " + name
                    + "  " + this.family + "外部类的n1 = " + Outer08.this.n1);
        }
    }

    public Inner08 getInner08Instance() {
        return new Inner08();
    }

    public void shuchu() {
        //外部类要使用成员内部类，需要创建对象后使用相关方法
        new Inner08().say();
        System.out.println(new Inner08().family);
    }

}