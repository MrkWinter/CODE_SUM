package com.mrk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.model.Book;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

public class BookDao {
	/**
	 * �������id�ж��Ƿ��ж�Ӧ���鼮���� (�ж�ĳһ����Ƿ����鼮�� �����ڰ� �޷�ɾ�����)
	 */
	public Boolean isExistByTypeId(Connection con, Integer typeId) {
		Boolean result = false;
		try {
			String sql = "select * from book where type_id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, typeId);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				result = true;
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ɾ��ͼ����Ϣ(�����)
	 */
	public Boolean deleteByIdAndName(Connection con, Integer bookId, String bookName) {
		Boolean result = false;
		try {
			String sql = "delete from book where id = ? and book_name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, bookId);
			pre.setString(2, bookName);
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
	 * �޸�ͼ����Ϣ(�����)
	 */
	public Boolean updateById(Connection con, Book book) {
		Boolean result = false;
		try {
			String sql = "update book set book_name = ?, type_id = ?, author = ?, publish = ?, price = ?, number = ?, status = ?, remark = ? where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, book.getBookName());
			pre.setInt(2, book.getTypeId());
			pre.setString(3, book.getAuthor());
			pre.setString(4, book.getPublish());
			pre.setDouble(5, book.getPrice());
			pre.setInt(6, book.getNumber());
			pre.setInt(7, book.getStatus());
			pre.setString(8, book.getRemark());
			pre.setInt(9, book.getId());
			Integer row = pre.executeUpdate();
			if (row != null && row > 0) {
				// ����Ϊʲô��������ͬʱ��Ȼ����Ӱ������Ϊ1����
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
	 * ��ѯͼ����Ϣ(����� �޸�)
	 */
	// ������ ��� ״̬����ѯ ��Ҫ����ѯ ֱ�ӷ��ؿ��õ�ResultSet ��Ϊ�����������ı����͵���� ���Բ�ʹ�ö�����Ϊ������Ϊ����
	public ResultSet listUpdateInfo(Connection con, String bookName, String typeName, Integer status) {

		// ����ֻѡ�������������������״̬����ѯ�鼮
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"SELECT book.id,book_name,type_name,author,publish,price,number,if(status=0,'�ɽ���','���ɽ���') status,book.remark FROM book,book_type where book.type_id = book_type.id");
			if (ToolUtils.isNotEmpty(status)) {
				sb.append("  and book.status = ?");
			} else if (ToolUtils.isNotEmpty(bookName)) {
				sb.append(" and book_name like ?");
			} else if (ToolUtils.isNotEmpty(typeName)) {
				sb.append(" and type_name like ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString());
			if (ToolUtils.isNotEmpty(status)) {
				pre.setInt(1, status);
			} else if (ToolUtils.isNotEmpty(bookName)) {
				pre.setString(1, "%" + bookName + "%");
			} else if (ToolUtils.isNotEmpty(typeName)) {
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
	 * ͼ�������� (�����)
	 */
	public Boolean add(Connection con, Book book) {
		Boolean result = false;
		try {
			// ���������� ������Ϣ�������
			String sql = "insert into book (book_name, type_id, author, publish, price, number, status, remark) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, book.getBookName());
			pre.setInt(2, book.getTypeId());
			pre.setString(3, book.getAuthor());
			pre.setString(4, book.getPublish());
			pre.setDouble(5, book.getPrice());
			pre.setInt(6, book.getNumber());
			pre.setInt(7, book.getStatus());
			pre.setNString(8, book.getRemark());
			Integer row = pre.executeUpdate();
			if (row != null && row > 0) {
				// ����ɹ�
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��ѯͼ����Ϣ(�����)
	 */
	// ������ ��� ״̬����ѯ ��Ҫ����ѯ ֱ�ӷ��ؿ��õ�ResultSet ��Ϊ�����������ı����͵���� ���Բ�ʹ�ö�����Ϊ������Ϊ����
	public ResultSet listInfo(Connection con, String bookName, String typeName, Integer status) {

		// ����ֻѡ���������������������ѯ�鼮
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"SELECT book.id,book_name,type_name,author,price,number,if(status=0,'�ɽ���','���ɽ���') status FROM book,book_type where book.type_id = book_type.id");
			if (status != null) {
				sb.append("  and book.status = ?");
			} else if (bookName != null) {
				sb.append(" and book_name like '%" + bookName + "%'");
			} else if (typeName != null) {
				sb.append(" and type_name like '%" + typeName + "%'");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString());
			if (status != null) {
				pre.setInt(1, status);
			}
			result = pre.executeQuery();
			// ����������ʱ���ر� pre ��ͬconһ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * ��ѯͼ����Ϣ ����ѯ ������ƵĲ��Ǻܺ� ���������淽���ϲ��Ż�
	 */
	public ResultSet list(Connection con, String bookName, String typeName, Integer status) {

		// ����ֻѡ���������������������ѯ�鼮
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"SELECT book.id,book_name,type_name,author,book.remark FROM book,book_type where book.type_id = book_type.id and book.status = ?");
			if (bookName != null) {
				sb.append(" and book_name like '%" + bookName + "%'");
			} else if (typeName != null) {
				sb.append(" and type_name like '%" + typeName + "%'");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString());
			pre.setInt(1, status);
			result = pre.executeQuery();
			// ����������ʱ���ر� pre ��ͬconһ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * ������� �����Ƿ���Խ���
	 */
	public Boolean IsBorrowBook(Connection con, Integer bookId, String bookName) {
		Boolean result = false;
		try {
			String sql = "select * from book where status = " + StatusOrTypeConstants.NOT_BORROW
					+ " and id = ? and book_name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, bookId);
			pre.setString(2, bookName);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				// ������ ���ҽ���һ��
				result = true;
				// ȡ������ �����ݿ���и��Ĳ���
				Book upBook = new Book();
				upBook.setId(rs.getInt("id"));
				upBook.setNumber(rs.getInt("number"));
				// ���ͼ������Ϊ1 ��ִ��ͼ��������һ�Ĳ�����ʹ����״̬��Ϊ���ɽ���
				// ���ͼ����������1 ��ִֻ�м�ȥ1�Ĳ��� ע�� ����û���̱߳��� ���׳������ݴ���
				String updateSql = "";
				if (upBook.getNumber() == 1) {
					updateSql = "update book set number = 0,status = " + StatusOrTypeConstants.ON_BORROW
							+ " where id = " + upBook.getId();
				} else {
					updateSql = "update book set number = " + (upBook.getNumber() - 1) + " where id = "
							+ upBook.getId();
				}
				PreparedStatement pre2 = con.prepareStatement(updateSql);
				int row = pre2.executeUpdate();
				if (row < 1) {
					throw new Exception("�������ʱ�������ݿ��쳣");
				}
				DBUtils.close(null, pre2, null);
			}
			DBUtils.close(rs, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * ������� �������ݿ�
	 */
	public void returnBook(Connection con, Integer id) {
		// �����ݿ���ͼ����Ϣ��1 ����id��ѯ���ݿ���Ϣ
		try {
			String sql = "select * from book where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Book upBook = new Book();
				upBook.setId(rs.getInt("id"));
				upBook.setNumber(rs.getInt("number"));
				// ���numberΪ0 ���һ����Ϊ�ɽ���״̬ ����ͽ�����һ
				String updateSql = "";
				if (upBook.getNumber() == 0) {
					updateSql = "update book set number = 1,status = " + StatusOrTypeConstants.NOT_BORROW
							+ " where id = " + upBook.getId();
				} else {
					updateSql = "update book set number = " + (upBook.getNumber() + 1) + " where id = "
							+ upBook.getId();
				}
				PreparedStatement pre2 = con.prepareStatement(updateSql);
				int row = pre2.executeUpdate();
				if (row < 1) {
					throw new Exception("�������ʱ�������ݿ��쳣");
				}
				DBUtils.close(null, pre2, null);
			}
			DBUtils.close(rs, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}