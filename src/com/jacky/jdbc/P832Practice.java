package com.jacky.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 2022/1/26
 */
public class P832Practice {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/jacky/jdbc/mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from `actor` where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date borndate = resultSet.getDate(4);
            String phone = resultSet.getString(5);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
        }

        preparedStatement.close();
        connection.close();

    }
}
