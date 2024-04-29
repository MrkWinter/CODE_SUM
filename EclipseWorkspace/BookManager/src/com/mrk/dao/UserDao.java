package com.mrk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

/**
 * User类dao类
 * 
 * @author MrkWinter
 *
 */
public class UserDao {
	/**
	 * 用户信息删除
	 */
	public Boolean deleteByIdAndName(Connection con,Integer userId,String username) {
		Boolean result = false;
		try {
			String sql = "delete from user where id = ? and username = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			pre.setString(2, username);
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
	 * 根据id查看用户是否唯一管理员 (用于删除逻辑校验 和 修改普通用户逻辑校验)
	 */
	public Boolean isOnlyRoot(Connection con, Integer userId) {
		Boolean result = false;
		try {
			String sql = "select * from user where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			ResultSet rs = pre.executeQuery();
			// 这里这样的逻辑判断是因为该sql语句最多只带会一条数据
			if (rs.next()) {
				Integer role = Integer.parseInt(rs.getString("role"));
				if (ToolUtils.isSame(role, StatusOrTypeConstants.ROOT)) {
					// 当前用户是管理员
					Connection con1 = DBUtils.getConnection();
					if (getRootNumber(con) == 1) {
						//管理员个数为1
						result = true;
					}
				}
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//获取管理员用户个数
	public Integer getRootNumber(Connection con) {
		Integer result = 0;
		try {
			String sql = "select count(*) from user where role = 1";
			PreparedStatement pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			DBUtils.close(null, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改用户信息
	 */
	public Boolean updateById(Connection con, User user) {
		Boolean result = false;
		try {
			String sql = "update user set username = ?,password = ?,role = ?,sex = ? ,phone = ? where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			pre.setInt(3, user.getRole());
			pre.setString(4, user.getSex());
			pre.setString(5, user.getPhone());
			pre.setInt(6, user.getId());
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
	 * 插入用户信息
	 */
	public Boolean insert(Connection con, User user) {
		Boolean result = false;
		try {
			String sql = "insert into user (username,password,role,sex,phone) values(?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			pre.setInt(3, user.getRole());
			pre.setString(4, user.getSex());
			pre.setString(5, user.getPhone());
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
	 * 根据用户名查询用户信息
	 * 
	 * @param con
	 * @param typeName
	 * @return
	 */
	public ResultSet listByUserName(Connection con, String userName) {
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"select id,if(role = 0,'普通用户','管理员') role ,username,password,sex,phone from user");
			if (ToolUtils.isNotEmpty(userName)) {
				// 优化防止sql注入
				sb.append(" and username like ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString().replace("and", "where"));
			if (ToolUtils.isNotEmpty(userName)) {
				pre.setString(1, "%" + userName + "%");
			}
			result = pre.executeQuery();
			// 这里结果集暂时不关闭 pre 会同con一起关
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 登录获取用户
	public User login(Connection con, User user) {
		User resultUser = null;
		try {
			String sql = "select * from user where userName = ? and password = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setRole(rs.getInt("role"));
				resultUser.setSex(rs.getString("sex"));
				resultUser.setPhone(rs.getString("phone"));
			}
			DBUtils.close(rs, pre, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultUser;
	}

	// 注册用户 添加用户
	public Boolean inserUser(Connection con, User user) {
		Boolean result = false;
		try {
			String sql = "insert into user values(null,?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			pre.setInt(3, user.getRole());
			pre.setString(4, user.getSex());
			pre.setString(5, user.getPhone());
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
}
