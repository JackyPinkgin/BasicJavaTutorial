package com.jacky.tankgame5;

import javax.swing.*;

/**
 * 2021/11/2
 */
public class TankGame05 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame05();
    }

    public TankGame05()  {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1200,950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
