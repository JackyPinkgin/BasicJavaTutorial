package com.jacky.ThreadUse;

/**
 * 2021/11/3
 */
public class P585Thread02 {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();

        Thread thread = new Thread(dog);
        thread.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hello " + i);
        }
        thread.interrupt();

    }
}

class Dog implements Runnable{

    int count;
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println("Dog Speak " + i);
            }

            try {
//                Thread.sleep(500);
                System.out.println("sleeping");
                Thread.sleep(20000);//20s
            } catch (InterruptedException e) {
                System.out.println("休眠被打断了");
            }
        }
    }
}