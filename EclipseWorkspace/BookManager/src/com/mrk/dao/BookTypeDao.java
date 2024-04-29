package com.mrk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mrk.model.BookType;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

public class BookTypeDao {
	/**
	 * 删除类别信息
	 */
	public Boolean deleteByIdAndName(Connection con, Integer typeId, String typeName) {
		Boolean result = false;
		try {
			String sql = "delete from book_type where id = ? and type_name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, typeId);
			pre.setString(2, typeName);
			Integer row = pre.executeUpdate();
			if (row != null && row > 0) {
				result = true;
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改类别信息
	 */
	public Boolean updateById(Connection con, BookType bookType) {
		Boolean result = false;
		try {
			String sql = "update book_type set type_name = ?,remark = ? where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, bookType.getTypeName());
			pre.setString(2, bookType.getRemark());
			pre.setInt(3, bookType.getId());
			Integer row = pre.executeUpdate();
			if (row != null && row > 0) {
				// 这里为什么在数据相同时仍然返回影响行数为1
				// TODO Question
				result = true;
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 添加类别信息
	 */
	public Boolean insert(Connection con, BookType bookType) {
		Boolean result = false;
		try {
			String sql = "insert into book_type (type_name,remark) values(?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, bookType.getTypeName());
			pre.setString(2, bookType.getRemark());

			Integer row = pre.executeUpdate();
			if (row != null && row > 0) {
				result = true;
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据类别名称查询类别信息
	 */

	public ResultSet listByTypeName(Connection con, String typeName) {
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer("select id,type_name,remark from book_type");
			if (ToolUtils.isNotEmpty(typeName)) {
				// 优化防止sql注入
				sb.append(" and type_name like ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString().replace("and", "where"));
			if (ToolUtils.isNotEmpty(typeName)) {
				pre.setString(1, "%" + typeName + "%");
			}
			result = pre.executeQuery();
			// 这里结果集暂时不关闭 pre 会同con一起关
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据类别名查询类别id
	 */
	public Integer getIdByTpye(Connection con, String typeName) {
		Integer result = null;
		try {
			String sql = "select id from book_type where type_name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, typeName);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				result = rs.getInt("id");
			}
			DBUtils.close(rs, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
