package com.jacky.tankgameall.tankgame4;

import javax.swing.*;

/**
 * 2021/11/2
 * 截止P608  完成了坦克可以打最多5个子弹，并且多颗子弹进行判断的逻辑
 */
public class TankGame04 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame04();
    }

    public TankGame04()  {
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
