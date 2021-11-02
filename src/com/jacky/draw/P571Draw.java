package com.jacky.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 2021/11/2
 * 坦克大战第一课
 */
public class P571Draw extends JFrame {//Jframe对应窗口

    private MyPanel mp;

    public static void main(String[] args) {
        new P571Draw();
    }

    public P571Draw() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        //当点击窗口的X时，程序会真正退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//先定义一个画板
class MyPanel extends JPanel {

    //Graphics 类提供了很多画图方法

    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类方法完成初始化

//        g.drawOval(10,10,100,100);

        //演示绘制不同的图形
//        g.drawLine(10,10,100,100);

//        g.drawRect(10,10,100,560);
        g.setColor(Color.RED);
//        g.fillRect(10,10,155,500);
//        g.fillOval(10,10,50,50);
        //获取图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        //画图片
//        g.drawImage(image,15,15,175,221,this);

        g.setColor(Color.RED);
        g.setFont(new Font("隶书", Font.BOLD, 20));
        //这里设置的坐标，是字符串的左下角
        g.drawString("吉喆你好",150,150);

    }
}