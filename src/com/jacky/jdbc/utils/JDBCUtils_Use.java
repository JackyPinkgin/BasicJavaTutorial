package com.jacky.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 2022/1/26
 */
public class JDBCUtils_Use {

    @Test
    public void update_data() {

        Connection connection=null;
        PreparedStatement preparedStatement=null;

        String update_sql = "update actor set name = ? where id = ?;";

        long start = System.currentTimeMillis();

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(update_sql);
            preparedStatement.setString(1,"吉喆");
            preparedStatement.setInt(2,2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement,null,connection);

        }
        long end = System.currentTimeMillis();

        System.out.println(start - end);

    }

}
