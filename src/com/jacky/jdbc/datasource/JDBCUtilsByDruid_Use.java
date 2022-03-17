//package com.jacky.jdbc.datasource;
//
//import com.jacky.jdbc.utils.JDBCUtils;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// * 2022/1/27
// */
//public class JDBCUtilsByDruid_Use {
//
//    @Test
//    public void update_data() {
//
//        Connection connection=null;
//        PreparedStatement preparedStatement=null;
//
//        String update_sql = "update actor set name = ? where id = ?;";
//
//        long start = System.currentTimeMillis();
//
//        try {
//            connection = JDBCUtilsByDruid.getConnection();
//            System.out.println(connection.getClass());
//            preparedStatement = connection.prepareStatement(update_sql);
//            preparedStatement.setString(1,"罗贯中");
//            preparedStatement.setInt(2,2);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCUtilsByDruid.closeConnection(null,preparedStatement,connection);
//
//        }
//        long end = System.currentTimeMillis();
//
//        System.out.println(-(start - end));
//
//    }
//
//}
