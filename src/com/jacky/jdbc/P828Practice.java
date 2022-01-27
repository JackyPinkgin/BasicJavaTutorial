package com.jacky.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 2022/1/26
 */
public class P828Practice {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/jacky/jdbc/mysql.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        String drop_sql = "DROP TABLE IF EXISTS `news`;";
        String create_sql = "create table `news`(\n" +
                "`id` int(10) not null auto_increment, \n" +
                "`city` varchar(32) not null default '', \n" +
                "`content` varchar(32) not null default '',\n" +
                "PRIMARY key(`id`)\n" +
                ");";
        String insert_sql = "INSERT into news value(null, '北京', '今日新闻1');";
        String insert_sql2 = "INSERT into news value(null, '上海', '今日新闻2');";
        String update_sql = "update news set content = '深圳新闻' where id = 2;";

        Statement statement = connection.createStatement();
        statement.execute(drop_sql);
        statement.execute(create_sql);
        statement.execute(insert_sql);
        statement.execute(insert_sql2);
        statement.execute(update_sql);

//        int i = statement.executeUpdate(create_sql);
//        System.out.println(i > 0 ? "success" : "fail");

        statement.close();
        connection.close();


    }
}
