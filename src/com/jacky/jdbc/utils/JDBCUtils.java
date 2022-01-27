package com.jacky.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 2022/1/26
 */
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;


    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/com/jacky/jdbc/mysql.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement statement, ResultSet resultSet, Connection connection) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("关闭结束");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
