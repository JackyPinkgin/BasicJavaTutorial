package com.jacky.innerclass;

public class P422StaticInnerClass {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        //外部其他类 访问静态内部类
        //方式一 通过类名直接访问 注意：如果内部类是私有的，就不可以在外部其他类访问
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        //方式二  编写一个方法，可以返回静态内部类的对象实例
        Outer10.Inner10 inner101 = outer10.getInner10();
        inner101.say();

        Outer10.Inner10 inner10_ = Outer10.getInner10_();
        inner10_.say();


    }
}


class Outer10{
    private int n1 =10;
    private static String name = "jacky";

    private static void cry(){}

    //可以添加任意访问修饰符
    //作用于：是整个类体
    //注意static，静态。只能访问外部类的其他静态成员
    static class Inner10{
        String name = "王五";
        public void say(){
            System.out.println(name+" 外部类name = "+Outer10.name);
            cry();
        }
    }
    public void m1(){
        new Inner10().say();
    }

    public Inner10 getInner10(){
        return new Inner10();
    }

    public static Inner10 getInner10_(){
        return new Inner10();
    }
}