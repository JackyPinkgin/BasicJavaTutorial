package com.jacky.poly.dynamic;

public class P315DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.i);
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }
    public int getI() {
        System.out.println("A的getI");
        return i;
    }
}

class B extends A {
    public int i = 20;

//    public int sum(){
//        return i+20;
//    }
    public int getI() {
        System.out.println("B的getI");
        System.out.println("i is "+this.i);
        return i;
    }

    public int sum1() {
        return i + 10;
    }
}