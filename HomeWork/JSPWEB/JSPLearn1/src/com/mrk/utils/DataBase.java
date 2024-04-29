package com.mrk.utils;

import java.sql.*;
import java.util.function.Predicate;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/book_shopping";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "xing123456";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataBase() {
    }

    public ResultSet executeQuery(String preSql,String ... date) {
        try {
            preparedStatement = connection.prepareStatement(preSql);
            for (int i = 1; i <= date.length; i++) {
                preparedStatement.setString(i, date[i-1]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int executeUpdate(String preSql,String ... date) {
        try {
            preparedStatement = connection.prepareStatement(preSql);
            for (int i = 1; i <= date.length; i++) {
                preparedStatement.setString(i, date[i-1]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if(resultSet !=null) {
                resultSet.close();
            }
            if(preparedStatement!=null) {
                preparedStatement.close();
            }
            if(connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
