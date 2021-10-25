package test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/10/25
 * 用来做各种测试用
 */
public class ATest {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add("jacky");
        System.out.println(list);

        System.out.println(list.get(2).getClass());

        System.out.println("........");

        int[] a = {1,5,3,8};
        Arrays.sort(a);
        for (int i : a) {
            System.out.print(i+"\t");
        }


    }
}
