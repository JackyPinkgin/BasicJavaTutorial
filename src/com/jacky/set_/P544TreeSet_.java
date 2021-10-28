package com.jacky.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 2021/10/28
 */
@SuppressWarnings("all")
public class P544TreeSet_ {
    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length()-((String)o2).length();
            }
        });
        treeSet.add("Jakcy");
        treeSet.add("tom");
        treeSet.add("a");
        treeSet.add("bc");
        treeSet.add("tt");
        System.out.println(treeSet);

    }
}
