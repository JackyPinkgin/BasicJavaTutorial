package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 2021/10/25
 * 用来做各种测试用
 */
public class ATest {
    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < 20000; i++) {
//            sb.append(i);
//        }
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);


        List<String> list = new ArrayList<String>();
        list.add("happy");
        list.add("happy2");
        list.add("happy3");

        list.forEach(s -> {
            System.out.println(s+", hello");
        });

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


    }
}
