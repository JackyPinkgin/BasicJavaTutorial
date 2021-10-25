package com.jacky.collection_;

import java.util.ArrayList;

/**
 * 2021/10/25
 */
@SuppressWarnings("all")
public class P511ArrayListSource {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        for (int i = 0; i <=10 ; i++) {
            list.add(i);
        }
        for (int i = 11; i <=15 ; i++) {
            list.add(i);
        }

        list.add(100);
        list.add(200);

        for (Object o : list) {
            System.out.println(o);

        }

    }
}
