package com.jacky.extend_;

public class P295 {
    public static void main(String[] args) {
        B b = new B();
//        b.check1();
        b.print();
    }
}

class A {
    int n1 = 1111;
    public A() {
        System.out.println('a');
    }
    public void check(){
        System.out.println("AAAAAAAAAAA");
    }
}

class B extends A {
    private int n1 = 2222;
    public B() {
        //super 和 this 只能出现一个
        this("hello");
        System.out.println('b');
    }

    void print(){
        System.out.println(n1);
        System.out.println(this.n1);
        System.out.println(super.n1);
    }

    void check1(){
        super.check();
    }

    public void check(){
        System.out.println("BBBBBBBBBBB");
    }

    B(String name) {
        super();
        System.out.println("b name");
    }
}