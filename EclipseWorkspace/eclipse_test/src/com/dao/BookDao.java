package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.domain.*;

import com.util.JDBCUtils;

public class BookDao {
	private Connection connection = null;
	// 增 删 改
	public Integer updateSql(String sql, Object... parameters) {
		connection = JDBCUtils.getConnection();
		Integer result = null;
		try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		for(int i = 1;i<=parameters.length;i++) {
			preparedStatement.setObject(i, parameters[i-1]);
		}
		result =  preparedStatement.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, null, connection);
		}
		return result;
	}

	// 查 多行多列
	public List<Book> quarryMulti(String sql, Object... parameters) {
		return null;
	}

	// 查 单行多列
	public List<Object> quarrySingle(String sql, Object... parameters) {
		return null;
	}

	// 查 单行单列
	public Book quarryScn(String sql, Object... parameters) {
		return null;
	}

}