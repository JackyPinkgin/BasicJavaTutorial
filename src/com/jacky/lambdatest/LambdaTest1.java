package com.jacky.lambdatest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 2022/2/16
 */
public class LambdaTest1 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("花了" + integer + "元");
            }
        });
    }

    @Test
    public void test2(){
        happyTime(1000, (money)->System.out.println("花了" + money + "元"));
    }

    @Test
    public void streamTest1(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str.toUpperCase();
            }
        }).forEach(System.out::print);
    }

    @Test
    public void streamTest2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (a, b) -> Integer.sum(a, b));
        System.out.println(reduce);

        List<Integer> collect = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

    }

    public void happyTime(Integer money, Consumer<Integer> con){
        con.accept(money);
    }
}
