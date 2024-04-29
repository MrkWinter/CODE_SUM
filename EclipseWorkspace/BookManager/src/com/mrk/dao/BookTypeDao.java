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
	 * ɾ�������Ϣ
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
	 * �޸������Ϣ
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
				// ����Ϊʲô��������ͬʱ��Ȼ����Ӱ������Ϊ1
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
	 * ��������Ϣ
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
	 * ����������Ʋ�ѯ�����Ϣ
	 */

	public ResultSet listByTypeName(Connection con, String typeName) {
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer("select id,type_name,remark from book_type");
			if (ToolUtils.isNotEmpty(typeName)) {
				// �Ż���ֹsqlע��
				sb.append(" and type_name like ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString().replace("and", "where"));
			if (ToolUtils.isNotEmpty(typeName)) {
				pre.setString(1, "%" + typeName + "%");
			}
			result = pre.executeQuery();
			// ����������ʱ���ر� pre ��ͬconһ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �����������ѯ���id
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
