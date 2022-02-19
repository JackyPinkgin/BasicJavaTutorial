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

        StringBuilder sb = new StringBuilder();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 20000; i++) {
            sb.append(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);


    }
}
