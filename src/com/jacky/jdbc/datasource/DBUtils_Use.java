//package com.jacky.jdbc.datasource;
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//import org.apache.commons.dbutils.handlers.ScalarHandler;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * 2022/1/27
// */
//public class DBUtils_Use {
//
//    //使用apache-DButils 工具类+Druid完成对actor表格的crud操作
//    @Test
//    public void testQueryMany() throws SQLException {//返回结果是多行
//
//        Connection connection = JDBCUtilsByDruid.getConnection();
//
//        QueryRunner queryRunner = new QueryRunner();
////        String sql = "update actor set name = ? where id >= ?;";
//        String sql2 = "select * from actor where id > ?;";
//
//        List<Actor> list = queryRunner.query(connection, sql2, new BeanListHandler<>(Actor.class), 1);
//
//        for (Actor actor : list) {
//            System.out.print(actor.toString());
//        }
//
//        JDBCUtilsByDruid.closeConnection(null, null, connection);
//    }
//
//    //使用apache-DButils 工具类+Druid 完成 返回的结果是单行记录（单个对象）
//    @Test
//    public void testQuerySingle() throws Exception {
//        Connection connection = JDBCUtilsByDruid.getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//        String sql = "select * from actor where id = ?";
//
//        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
//        JDBCUtilsByDruid.closeConnection(null, null, connection);
//        System.out.println(actor);
//
//    }
//
//    //使用apache-DButils 工具类+Druid 完成 返回的结果是单行单列 场景 返回的就是object
//    @Test
//    public void testScalar() throws Exception {
//        Connection connection = JDBCUtilsByDruid.getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//
//        String sql = "select name from actor where id = ?";
//        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 3);
//        if (obj == null) {
//            System.out.println("返回结果为空");
//        } else {
//            System.out.println(obj);
//        }
//        JDBCUtilsByDruid.closeConnection(null, null, connection);
//    }
//
//    //使用apache-DButils 工具类+Druid 完成 DML 操作 （update, insert, delete）
//    @Test
//    public void testDML() throws Exception {
//        Connection connection = JDBCUtilsByDruid.getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//
//        String sql = "update actor set name =? where id = ?";
//        String sql2 = "delete from actor where id = 6";
//        String sql3 = "insert into actor values(null,?,?,?,?)";
////        int affectedRow = queryRunner.update(connection, sql, "王家卫", 10);
//        int affectedRow = queryRunner.update(connection, sql3,"kobe byrant","男","1987-5-4","687433215");
////        int affectedRow = queryRunner.update(connection, sql2);
//
//        if (affectedRow == 0) {
//            System.out.println("没有对表格产生影响");
//        } else {
//            System.out.println(affectedRow + " 行被修改");
//        }
//
//        JDBCUtilsByDruid.closeConnection(null, null, connection);
//    }
//
//}
