package com.jacky.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 2021/10/22
 */
public class P502CollectionIterator {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Collection col= new ArrayList();
        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }


    }
}
