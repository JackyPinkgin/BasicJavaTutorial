package com.jacky.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/22
 */
public class P501ArrayList {
//    @SuppressWarnings("all")
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(10);
        list.add("shei");
        list.add(true);
        System.out.println(list);

//        list.remove(0);
//        list.remove((Integer)10);
        list.remove(true);
        System.out.println(list);

        ArrayList list2 = new ArrayList();
        list2.add("jizhe");
        list2.add("wangjun");
        list2.add("dongcunrui");
        list2.add(10);
        list.removeAll(list2);
        System.out.println(list);
        System.out.println("--------");
        list.addAll(list2);
        System.out.println(list);
//        list.clear();
        System.out.println(list);
        System.out.println(list2);
        System.out.println("----------");
        System.out.println(list2.containsAll(list));
        System.out.println(list2.contains(10));


    }
}
