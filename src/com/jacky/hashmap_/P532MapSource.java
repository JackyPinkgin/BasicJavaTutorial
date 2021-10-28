package com.jacky.hashmap_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2021/10/27
 */
@SuppressWarnings("all")
public class P532MapSource {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("no1","jacky");
        map.put("no2","tom");
        System.out.println(map.size());

        System.out.println(map.get("no1"));

        Set set = map.entrySet();
        for (Object o :set) {
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }


    }
}
