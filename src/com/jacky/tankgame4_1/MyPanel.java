package com.jacky.tankgame4_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 2021/11/2
 * 坦克大战绘图区域
 */
//为了监听键盘事件，要实现接口
//为了让panel不停的重绘子弹，需要将panel实现runnable，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克

    Hero hero = null;

    Vector<EnemyTank> enemyTanks = new Vector<>();//创建敌对坦克的list
    int enemyTankSize = 3;

    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();

    //定义三张炸弹图片，用于显示炸弹效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        //构造器，先生成一个主角坦克，设定移动速度是3像素
        hero = new Hero(500, 200);
        hero.setSpeed(3);

        for (int i = 0; i < enemyTankSize; i++) {//创建敌对坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            //启动敌人坦克线程，让动起来
            new Thread(enemyTank).start();
//            enemyTank.setSpeed(3);
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            //启动shot对象线程
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        if (hero!=null && hero.isLive) {
            //画出主角坦克
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }

        //画出hero射击的子弹
        if (hero.shot != null && hero.shot.isLive) {
            g.fill3DRect(hero.shot.x, hero.shot.y, 2, 2, false);
        }

        //将shots子弹集合遍历取出绘制
//        for (int i = 0; i < hero.shots.size(); i++) {
//            Shot shot = hero.shots.get(i);
//            if (shot != null && shot.isLive) {
//                g.fill3DRect(shot.x, shot.y, 2, 2, false);
//            }else {//如果shot对象已经无效，就从shots集合中拿掉
//                hero.shots.remove(shot);
//            }
//        }

        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //如果bomblife为0，从bombs集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        //画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断地方当前坦克是否还存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出敌人坦克的所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {
                        g.fill3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    //画出坦克--封装方法

    /**
     * g 画笔
     * direct 坦克方向
     * type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0://敌人的坦克
                g.setColor(Color.CYAN);
                break;
            case 1://我们的坦克
                g.setColor(Color.yellow);
                break;
        }

        //0表示向上，1表示向右，2表示向下，3表示向左
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克顶部的圆形
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克顶部的圆形
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克顶部的圆形
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克顶部的圆形
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时不处理");
        }
    }

    //如果坦克可以发出多个子弹，判断子弹是否击中敌人时，需要子弹集合中所有子弹都取出和敌人的所有坦克进行判断
    public void hitEnemyTank(){
//        for (int j = 0; j < hero.shots.size(); j++) {
//            Shot shot = hero.shots.get(j);
//            if (shot != null && shot.isLive) {
//                //遍历敌人所有坦克
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(shot, enemyTank);
//                    //可以在判断hitTank方法里删掉enemyTank
//    //                    if (!enemyTank.isLive) {
//    //                        enemyTanks.remove(enemyTank);
//    //                    }
//                }
//            }
//        }
        //单颗子弹。
        if (hero.shot != null && hero.shot.isLive) {
            //遍历敌人所有坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(hero.shot, enemyTank);
                //可以在判断hitTank方法里删掉enemyTank
                if (!enemyTank.isLive) {
                    enemyTanks.remove(enemyTank);
                }
            }
        }
    }

    //编写方法判断子弹是否击中敌人坦克
    //后面再把参数里的enemyTank改成tank
    public void hitTank(Shot s, Tank enemyTank) {
        switch (enemyTank.getDirect()) {
            //敌方坦克方向为上下走动
            case 0:
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //编写方法判断敌人子弹是否击中我方坦克

    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中hero坦克

                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() >= 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 <= 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 <= 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() >= 0) {
                hero.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            //如果按下J键，就发射一枚子弹
            System.out.println("用户按下了J，开始射击");
            if (hero.shot == null || !hero.shot.isLive) {
                hero.shotEnemyTank();
            }

            //发射多颗子弹
//            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {//每隔100毫秒，重绘区域
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断hero的子弹是否击中敌方坦克
            hitEnemyTank();

            //判断敌人坦克是否击中我们
            hitHero();
            this.repaint();
        }
    }
}
