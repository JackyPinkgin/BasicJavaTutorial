package com.jacky.ThreadUse;

/**
 * 2021/11/3
 */
public class P586Thread03 {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        B b = new B();
        b.start();
    }
}

class A extends Thread{

    int count;
    @Override
    public void run() {
        while (count<10){
            System.out.println("hello world "+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread{
    int count;
    @Override
    public void run() {
        while (count<5){
            System.out.println("hi"+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
