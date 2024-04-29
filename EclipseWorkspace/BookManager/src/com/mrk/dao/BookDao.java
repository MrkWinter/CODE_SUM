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
	 * 根据类别id判断是否有对应的书籍存在 (判断某一类别是否与书籍绑定 若存在绑定 无法删除类别)
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
	 * 删除图书信息(管理端)
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
	 * 修改图书信息(管理端)
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
				// 这里为什么在数据相同时仍然返回影响行数为1？？
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
	 * 查询图书信息(管理端 修改)
	 */
	// 以书名 类别 状态来查询 需要多表查询 直接返回可用的ResultSet 因为传入数据有文本类型的类别 所以不使用对象作为参数较为方便
	public ResultSet listUpdateInfo(Connection con, String bookName, String typeName, Integer status) {

		// 这里只选择可以以书名或类名或状态来查询书籍
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"SELECT book.id,book_name,type_name,author,publish,price,number,if(status=0,'可借阅','不可借阅') status,book.remark FROM book,book_type where book.type_id = book_type.id");
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
			// 这里结果集暂时不关闭 pre 会同con一起关
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 图书类别添加 (管理端)
	 */
	public Boolean add(Connection con, Book book) {
		Boolean result = false;
		try {
			// 除了主键外 所有信息必须添加
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
				// 插入成功
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询图书信息(管理端)
	 */
	// 以书名 类别 状态来查询 需要多表查询 直接返回可用的ResultSet 因为传入数据有文本类型的类别 所以不使用对象作为参数较为方便
	public ResultSet listInfo(Connection con, String bookName, String typeName, Integer status) {

		// 这里只选择可以以书名或类名来查询书籍
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"SELECT book.id,book_name,type_name,author,price,number,if(status=0,'可借阅','不可借阅') status FROM book,book_type where book.type_id = book_type.id");
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
			// 这里结果集暂时不关闭 pre 会同con一起关
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 查询图书信息 多表查询 这里设计的不是很好 可以与上面方法合并优化
	 */
	public ResultSet list(Connection con, String bookName, String typeName, Integer status) {

		// 这里只选择可以以书名或类名来查询书籍
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
			// 这里结果集暂时不关闭 pre 会同con一起关
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 借书操作 检验是否可以借书
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
				// 有数据 有且仅有一条
				result = true;
				// 取出数据 对数据库进行更改操作
				Book upBook = new Book();
				upBook.setId(rs.getInt("id"));
				upBook.setNumber(rs.getInt("number"));
				// 如果图书数量为1 则执行图书数量减一的操作并使借阅状态改为不可借阅
				// 如过图书数量大于1 则只执行减去1的操作 注意 这里没有线程保护 容易出现数据错误
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
					throw new Exception("借书操作时更新数据库异常");
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
	 * 还书操作 更新数据库
	 */
	public void returnBook(Connection con, Integer id) {
		// 将数据库中图书信息加1 根据id查询数据库信息
		try {
			String sql = "select * from book where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Book upBook = new Book();
				upBook.setId(rs.getInt("id"));
				upBook.setNumber(rs.getInt("number"));
				// 如果number为0 则加一更改为可借阅状态 否则就仅仅加一
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
					throw new Exception("还书操作时更新数据库异常");
				}
				DBUtils.close(null, pre2, null);
			}
			DBUtils.close(rs, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}