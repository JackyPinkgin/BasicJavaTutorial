package com.jacky.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 2021/11/2
 */
public class BallMove extends JFrame {

    MyPanel mp;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}


//KeyListener是监听器，来监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动，把小球左上角坐标设置为变量

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符输入时，该方法会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {

        //根据用户按下的键来处理小球的移动

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            y++;
            y+=5;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
//            y--;
            y-=5;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            x--;
            x-=5;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            x++;
            x+=5;
        }
        this.repaint();
    }

    //某个键松开，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}