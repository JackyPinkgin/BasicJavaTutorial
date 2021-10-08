package com.jacky.extend_;

public class family {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.name);
        System.out.println(son.getAge());
        System.out.println(son.getAge1());

    }
}

class Grandpa {
    String name = "grandpa";
    int age = 100;

    public int getAge1() {
        return age;
    }
}

class Father extends Grandpa {
    String name = "father";
    private int age = 50;

    public int getAge() {
        return age;
    }
}

class Son extends Father {
    String name = "son";

}