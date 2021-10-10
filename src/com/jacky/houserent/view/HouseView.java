package com.jacky.houserent.view;

/*
* 1、显示界面
* 2、接受用户的输入
* 3、调用HouseService完成对房屋信息的各种操作
*
* */

import sun.text.normalizer.Utility;

public class HouseView {

    private boolean loop = true;
    private char key = ' ';


    public void mainMenu(){

        do {
            System.out.println("==========房屋出租系统菜单==========");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房源");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 显示房屋信息");
            System.out.println("\t\t\t6 退出");
            System.out.println("请输入你的选择（1-6）");
//            key= Utility.readChar();

        }while (loop);

    }

}
