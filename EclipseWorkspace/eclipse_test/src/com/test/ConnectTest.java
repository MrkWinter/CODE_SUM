package com.test;

import java.sql.DriverManager;

import java.sql.Connection;

public class ConnectTest {
	public static void main(String args[]) throws Exception {
		String url = "jdbc:mysql://localhost:3306/db03";
		String user = "root";
		String password = "xing123456";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.print(connection);
	}
}
