//package com.jacky.jdbc.datasource;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
///**
// * 2022/1/26
// */
//public class C3P0_Practice {
//
//    @Test
//    public void test_c3p0() throws SQLException {
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("jacky_database111");
//
//        long l = System.currentTimeMillis();
//        for (int i = 0; i < 500; i++) {
//            Connection connection = comboPooledDataSource.getConnection();
//            connection.close();
//        }
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1 - l);
//    }
//
//}
