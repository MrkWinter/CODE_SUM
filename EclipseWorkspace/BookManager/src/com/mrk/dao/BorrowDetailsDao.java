package com.mrk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.model.BorrowDetails;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

public class BorrowDetailsDao {
	/**
	 * 检查对应id的书籍是否有未归还的书籍
	 */
	public Boolean isExistBorrowByBookId(Connection con, Integer bookId) {
		Boolean result = false;
		
		try {
			String sql = "select * from borrow_details where book_id = ? and status = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, bookId);
			pre.setInt(2,StatusOrTypeConstants.NOT_RETURN);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				result = true;
			}
			DBUtils.close(rs, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 查询借阅信息 管理端
	 */
	public ResultSet listByNameAndStatus(Connection con, String userName, String bookName, Integer status) {

		// 这里只选择可以以书名或用户名或状态来查询书籍 多(三)表查询
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"select user.username,book_name,IF(borrow_details.status = 0,'在借','已还') status,borrow_time,return_time "
							+ "from borrow_details,book,user where book_id = book.id and user_id = user.id ");
			if (ToolUtils.isNotEmpty(userName)) {
				sb.append(" and username like ?");
			} else if (ToolUtils.isNotEmpty(bookName)) {
				sb.append(" and book_name like ?");
			} else if (status != null) {
				sb.append(" and borrow_details.status = ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString());

			// 预处理填充
			if (ToolUtils.isNotEmpty(userName)) {
				pre.setString(1, "%" + userName + "%");
			}
			if (ToolUtils.isNotEmpty(bookName)) {
				pre.setString(1, "%" + bookName + "%");
			}
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
	 * 查询借阅信息
	 */
	public ResultSet list(Connection con, String bookName, Integer status, Integer userId) {

		// 这里只选择可以以书名或类名来查询书籍
		ResultSet result = null;
		try {
			if (userId == null) {
				return null;
			}
			StringBuffer sb = new StringBuffer(
					"SELECT borrow_details.id,book_name,IF(borrow_details.status = 0,'在借','已还') status,borrow_time,return_time FROM borrow_details,book WHERE book_id = book.id ");
			sb.append(" and user_id = ?");
			if (bookName != null) {
				sb.append(" and book_name like '%" + bookName + "%'");
			} else if (status != null) {
				sb.append(" and borrow_details.status = ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString());
			pre.setInt(1, userId);
			if (status != null) {
				pre.setInt(2, status);
			}
			result = pre.executeQuery();
			// 这里结果集暂时不关闭 pre 会同con一起关
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 借书操作
	 */
	public Boolean insert(Connection con, BorrowDetails borrowDetails) {
		Boolean result = false;
		try {
			String sql = "insert into borrow_details values(null,?,?,?,?,null)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, borrowDetails.getUserId());
			pre.setInt(2, borrowDetails.getBookId());
			pre.setInt(3, borrowDetails.getStatus());
			pre.setLong(4, borrowDetails.getBorrowTime());
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

	// 根据用户id 和 书籍名查询用户是否借过此书 并且未归还
	public Boolean isBorrowed(Connection con, BorrowDetails borrowDetails) {
		Boolean result = false;
		try {
			String sql = "select * from borrow_details where user_id = ? and book_id = ? and status = "
					+ StatusOrTypeConstants.NOT_RETURN;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, borrowDetails.getUserId());
			pre.setInt(2, borrowDetails.getBookId());
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				// 有数据
				result = true;
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 还书操作
	 */
	public Boolean update(Connection con, BorrowDetails borrowDetails) {
		Boolean result = false;
		try {
			String sql = "update borrow_details set status = " + StatusOrTypeConstants.RETURND + ",return_time = "
					+ ToolUtils.getCurrentTime() + " where id = ? and user_id = ? and status = "
					+ StatusOrTypeConstants.NOT_RETURN;
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, borrowDetails.getId());
			pre.setInt(2, borrowDetails.getUserId());
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

	/*
	 * 根据id查询借阅信息
	 */
	public BorrowDetails getByid(Connection con, Integer id) {
		BorrowDetails result = new BorrowDetails();
		try {
			String sql = "select * from borrow_details where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setUserId(rs.getInt("user_id"));
				result.setBookId(rs.getInt("book_id"));
				result.setBorrowTime(rs.getLong("borrow_time"));
				result.setReturnTime(rs.getLong("return_time"));
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
