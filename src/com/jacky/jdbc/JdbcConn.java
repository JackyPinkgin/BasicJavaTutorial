//package com.jacky.jdbc;
//
//import com.mysql.jdbc.Driver;
//import org.junit.jupiter.api.Test;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
///**
// * 2022/1/26
// * <p>
// * java链接mysql的5钟方式
// */
//public class JdbcConn {
//
//    @Test
//    public void connect01() throws SQLException {
//        Driver driver = new Driver();
//        String url = "jdbc:mysql://localhost:3306/testtest";
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "jacky");
//        Connection connect = driver.connect(url, properties);
//        System.out.println(connect);
//
//    }
//
//    @Test
//    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        //使用反射加载Driver类，减少依赖性
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) aClass.newInstance();
//
//        String url = "jdbc:mysql://localhost:3306/testtest";
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "jacky");
//
//        Connection connect = driver.connect(url, properties);
//        System.out.println("方式2 = " + connect);
//
//    }
//
//    //方式三 使用DriverManager代替Driver进行统一管理
//
//    @Test
//    public void connect03() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) aClass.newInstance();
//
//        String url = "jdbc:mysql://localhost:3306/testtest";
//        String user = "root";
//        String password = "jacky";
//
//        DriverManager.registerDriver(driver);
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println("方式3 = " + connection);
//
//    }
//
//    //方式4 使用 Class.forName自动完成注册驱动，简化代码
//    @Test
//    public void connect04() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/testtest";
//        String user = "root";
//        String password = "jacky";
//
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println("方式4 = " + connection);
//    }
//
//
//    //方式5 增加配置文件
//
//    @Test
//    public void connect05() throws IOException, ClassNotFoundException, SQLException {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("src/com/jacky/jdbc/mysql.properties"));
//        String user = properties.getProperty("user");
//        String pwd = properties.getProperty("password");
//        String driver = properties.getProperty("driver");
//        String url = properties.getProperty("url");
//
//        Class.forName(driver);
//        Connection connection = DriverManager.getConnection(url, user, pwd);
//        System.out.println("方式5 = " + connection);
//
//    }
//
//}
