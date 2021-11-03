package test;

import java.time.LocalDate;
import java.util.Collections;

/**
 * 2021/10/27
 */
public class BTest {
    public static void main(String[] args) {

        LocalDate past = LocalDate.of(2020,11,14);
        System.out.println(past.plusDays(340));

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());

//        Collections.reverse();

    }
}
