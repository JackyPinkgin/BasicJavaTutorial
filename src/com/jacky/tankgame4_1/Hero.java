package com.jacky.tankgame4_1;

import java.util.Vector;

/**
 * 2021/11/2
 */
public class Hero extends Tank {

    //定义一个shot对象

    Shot shot = null;
    //可以发射多个子弹
//    Vector<Shot> shots = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank(){

//        if (shots.size()==5){
//            return;
//        }

        //创建shot对象
        switch (getDirect()){//得到坦克的坐标
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY()+20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY()+60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY()+20, 3);
                break;
        }

        //把新创建的shot放入shots
//        shots.add(shot);
        new Thread(shot).start();
    }
}
