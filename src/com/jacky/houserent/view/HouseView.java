package com.jacky.houserent.view;

/*
 * 1、显示界面
 * 2、接受用户的输入
 * 3、调用HouseService完成对房屋信息的各种操作
 *
 * */

import com.jacky.houserent.domain.House;
import com.jacky.houserent.service.HouseService;
import com.jacky.houserent.utils.Utility;

public class HouseView {

    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);//设置数组大小为10

    //编写修改信息
    public void updateHouse() {
        System.out.println("=============修改房屋信息============");
        System.out.print("请选择要修改的房屋id(-1表示退出): ");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("=============你放弃修改房屋信息============");
            return;
        }

        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("=============房屋信息不存在============");
            return;
        }

        System.out.print("姓名(" + house.getName() + "): ");
        house.setName(Utility.readString(8, house.getName()));
        System.out.print("电话(" + house.getPhone() + "): ");
        house.setPhone(Utility.readString(12, house.getPhone()));
        System.out.print("地址(" + house.getAddress() + "): ");
        house.setAddress(Utility.readString(18, house.getAddress()));
        System.out.print("租金(" + house.getRent() + "): ");
        house.setRent(Utility.readInt(house.getRent()));
        System.out.print("状态(" + house.getState() + "): ");
        house.setState(Utility.readString(3, house.getState()));
    }


    //编写查找信息
    public void findHouse() {
        System.out.println("=============查找房屋信息============");
        System.out.print("请输入要查找的id: ");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("=============查找的房屋ID不存在============");
        }
    }

    //完成退出确认
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //编写delHouse()
    public void delHouse() {
        System.out.println("=============删除房屋信息============");
        System.out.print("请输入待删除房屋的编号(-1删除)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("=============放弃删除房屋信息============");
            return;
        }
//        System.out.print("请确认是否删除(Y/N),小心选择：");
        char choice = Utility.readConfirmSelection();//该方法本身就有循环判断逻辑
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("=============删除房屋信息成功============");
            } else {
                System.out.println("=============房屋编号不存在，删除失败============");
            }
        } else {
            System.out.println("=============放弃删除房屋信息============");
        }
    }


    //编写addHouse()添加新房屋
    public void addHouse() {
        System.out.println("=============添加房屋============");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);

        House newHouse = new House(1, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("=============添加房屋成功============");
        } else {
            System.out.println("=============添加房屋失败============");
        }
    }


    //编写listHouse()显示房屋列表
    public void listHouse() {
        System.out.println("==========房屋列表==========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("==========房屋列表显示完毕==========");
    }


    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("==========房屋出租系统菜单==========");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 显 示 房 屋 信 息");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择(1-6): ");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }


        } while (loop);

    }

}
