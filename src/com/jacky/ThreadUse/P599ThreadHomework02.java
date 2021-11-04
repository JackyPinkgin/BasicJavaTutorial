package com.jacky.ThreadUse;

/**
 * 2021/11/4
 */
public class P599ThreadHomework02 {
    public static void main(String[] args) {
        AA jacky = new AA();
        Thread thread1 = new Thread(jacky);
        Thread thread2 = new Thread(jacky);
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();

    }
}


class AA implements Runnable{
    private int balance = 10000;

    @Override
    public void run() {
        while (true){
            synchronized (this) {

                if (balance < 1000) {
                    System.out.println("余额为 " + balance + ", 不能取钱");
                    break;
                }
                balance-=1000;
                System.out.println(Thread.currentThread().getName() + "取出1000，当前余额为" + balance);

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}