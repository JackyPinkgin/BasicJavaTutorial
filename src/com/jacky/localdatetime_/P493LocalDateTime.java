package com.jacky.localdatetime_;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * 2021/10/21
 */
public class P493LocalDateTime {
    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getDayOfYear());
        System.out.println(ldt.getMonthValue());


        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(d));


        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();

        //DateTimeFormatter
        DateTimeFormatter dff = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        DateTimeFormatter dff1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dff.format(now1));

        LocalDate localDate = now.plusDays(890);
        System.out.println(dff1.format(localDate));

    }


}
