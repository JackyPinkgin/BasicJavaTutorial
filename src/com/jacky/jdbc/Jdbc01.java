//package com.jacky.jdbc;
//
//import com.mysql.jdbc.Driver;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
///**
// * 2022/1/26
// */
//public class Jdbc01 {
//    public static void main(String[] args) throws SQLException {
//
//        Driver driver = new Driver();
//
//        String url = "jdbc:mysql://localhost:3306/testtest";
//
//        Properties properties = new Properties();
//        properties.setProperty("user","root");
//        properties.setProperty("password","jacky");
//
//        Connection connect = driver.connect(url, properties);
//
//        String sql = "insert into actor values(null, 'Jacky','男','1993-10-05','110')";
//
//
//        Statement statement = connect.createStatement();
//        int rows = statement.executeUpdate(sql);
//
//        System.out.println(rows>0?"成功":"失败");
//        statement.close();
//        connect.close();
//
//
//
//    }
//}
