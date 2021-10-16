package com.jacky.innerclass;

public class P416P417AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {
    private int n1 = 10;

    public void method() {
        //基于接口的匿名内部类

        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫。。。");
            }
        };
        tiger.cry();
        System.out.println(tiger.getClass());//Outer04$1


        Father father = new Father("jacky") {
            //这里的("Jacky“)会传递给构造器
            public int n = 10000;

            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }

            @Override
            public void hello(int i) {
                System.out.println("hello xinde = " + i + "fulei aa = " + super.aa + " neibu= " + n);
            }

            public void shuchu() {
                System.out.println("匿名内部类新建的方法");
            }

        };
//        father.test();
        father.hello(Father.num);
        System.out.println(father.getClass());//Outer04$2


        //基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("吃的方法的重写");
            }
        };
        animal.eat();
        System.out.println(animal.getClass());

    }
}

interface IA {
    public void cry();
}

class Father {
    public Father(String name) {
        System.out.println("接收到name=" + name);
    }

    public static int num = 100;
    public int aa = 50;

    public void test() {
        System.out.println("原来的test方法");
    }

    public void hello(int i) {
        System.out.println("hello");
    }
}

abstract class Animal {
    abstract void eat();
}