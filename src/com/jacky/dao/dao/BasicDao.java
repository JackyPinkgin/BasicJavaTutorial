package com.jacky.dao.dao;

import com.jacky.dao.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 2022/1/27
 */
public class BasicDao<T> {//使用泛型指定具体类型

    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法，针对任意的表格
    public int update(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(null,null,connection);
        }
    }

    //返回多个对象（即查询的结果是多行），针对任意表格
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){

        Connection connection= null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(null,null,connection);
        }

    }

    //返回单个对象（即查询的结果是单行），针对任意表格
    public T querySingle(String sql, Class<T> clazz, Object... parameters){

        Connection connection= null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(null,null,connection);
        }

    }

    //返回单行单列（即查询的结果是单行单列），针对任意表格
    public Object queryScalar(String sql, Object... parameters){

        Connection connection= null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            Object query = qr.query(connection, sql, new ScalarHandler(), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.closeConnection(null,null,connection);
        }

    }
}
