package com.jacky.houserent.service;

import com.jacky.houserent.domain.House;

import javax.security.auth.login.CredentialNotFoundException;

/**
 * HouseService.java<=>类 [业务层]
 * //定义House[] ,保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */


public class HouseService {

    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "jacky", "189", "深圳", 2000, "未出租");
    }

    public House[] list() {
        return houses;
    }

    public House findById(int findId){
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {//说明delId在数组中不存在
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
        return true;
    }


    //编写add(House newHouse)，把新的house对象加入到houses[]，返回boolean值
    public boolean add(House newHouse) {
        //判断是否还可以继续添加，暂时不考虑数组扩容问题
        if (houseNums == houses.length) {
            System.out.println("数组已满，不能再添加");
            return false;
        }
        newHouse.setId(++idCounter);
        houses[houseNums++] = newHouse;
        return true;

    }


}
