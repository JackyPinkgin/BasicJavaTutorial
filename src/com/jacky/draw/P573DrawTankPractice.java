package com.jacky.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 2021/11/2
 */
public class P573DrawTankPractice extends JFrame {

    private MyPanel1 mp1;
    public static void main(String[] args) {
        new P573DrawTankPractice();
    }

    public P573DrawTankPractice() {
        mp1 = new MyPanel1();
        this.add(mp1);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel1 extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.CYAN);
        g.drawRect(15,15,5,20);
        g.drawRect(30,15,5,20);
        g.drawOval(20,20,5,5);

    }
}
