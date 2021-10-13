package com.jacky.interface_;

public class TestInterface {
    public static void main(String[] args) {
        A a = new A();
        a.hi();

    }
}


class A implements Interface{

    @Override
    public void hi() {
        System.out.println("hi");
    }


    public void hello(){

    }
}