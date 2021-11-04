package com.jacky.tankgame4;

/**
 * 2021/11/2
 */
public class Hero extends Tank {

    //定义一个shot对象

    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank(){
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
        new Thread(shot).start();
    }
}
