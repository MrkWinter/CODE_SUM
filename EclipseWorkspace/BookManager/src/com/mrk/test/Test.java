package com.mrk.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mrk.dao.*;

import com.mrk.model.*;
import com.mrk.utils.DBUtils;

public class Test {
	public static void main(String[] args) throws SQLException {
//		UserDao userDao = new UserDao();
//		User user = new User();
//		user.setUserName("zhang");
//		user.setPassword("123456");
//		user.setPhone("1212");
//		user.setSex("na");
//		user.setRole(0);
Connection con = DBUtils.getConnection();
//		User resut = userDao.login(DBUtils.getConnection(), user);
//		System.out.println(resut == null);
//		userDao.inserUser(DBUtils.getConnection(), user);
		
//		BookTypeDao bookType = new BookTypeDao();
//	Integer in = 	bookType.getIdByTpye(con, "–°Àµ¿‡");
//	System.out.println(in);
BookDao bookdao = new BookDao();
ResultSet re = bookdao.list(con,null,null,0);
System.out.println(re);
re.next();
String s = re.getString("author");
System.out.println(s);

		
	}
}
