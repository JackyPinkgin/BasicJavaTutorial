package com.jacky.tankgame2;

import javax.swing.*;

/**
 * 2021/11/2
 */
public class TankGame02 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame02();
    }

    public TankGame02()  {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
