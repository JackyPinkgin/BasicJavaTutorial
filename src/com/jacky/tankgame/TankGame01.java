package com.jacky.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * 2021/11/2
 */
public class TankGame01 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame01();
    }

    public TankGame01()  {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
