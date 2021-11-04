package com.jacky.ThreadUse;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

/**
 * 2021/11/4
 */
public class P598ThreadHomework01 {
    public static void main(String[] args) {
        One one = new One();
        Two two = new Two(one);
        one.start();
        two.start();

    }
}

class One extends Thread {

    public boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (loop) {
            System.out.println(random.nextInt(100) + 1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Two extends Thread {

    private One one;
    private Scanner scanner = new Scanner(System.in);

    public Two(One one) {
        this.one = one;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令Q表示退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                one.setLoop(false);
                System.out.println("Two线程退出");
                break;
            }
        }

    }

}