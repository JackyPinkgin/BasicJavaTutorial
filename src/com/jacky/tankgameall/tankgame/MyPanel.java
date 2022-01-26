package com.jacky.tankgameall.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * 2021/11/2
 * 坦克大战绘图区域
 */
public class MyPanel extends JPanel {
    //定义我的坦克

    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        drawTank(hero.getX(), hero.getY(), g, 0, 1);
        drawTank(hero.getX() + 60, hero.getY(), g, 0, 0);
    }

    //画出坦克--封装方法

    /**
     * g 画笔
     * direct 坦克方向
     * type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.CYAN);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克顶部的圆形
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            default:
                System.out.println("暂时不处理");
        }


    }
}
