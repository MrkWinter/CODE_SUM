package com.mrk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 	连接数据库工具类
 * @author MrkWinter
 *
 */
public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/book_manager";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "xing123456";

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(ResultSet resultSet, Statement statement, Connection connection) {

		try {
			if (resultSet != null)
				resultSet.close();
			else if (statement != null)
				statement.close();
			else if (connection != null)
				connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
