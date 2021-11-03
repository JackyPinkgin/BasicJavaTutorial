package com.jacky.ThreadUse;

/**
 * 2021/11/3
 */
public class P582Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }
}


class Cat extends Thread{

    int num = 1;

    @Override
    public void run() {
        while(num<=10) {

            System.out.println("Cat speak" + (num++));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}