package com.mrk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

/**
 * User��dao��
 * 
 * @author MrkWinter
 *
 */
public class UserDao {
	/**
	 * �û���Ϣɾ��
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
	 * ����id�鿴�û��Ƿ�Ψһ����Ա (����ɾ���߼�У�� �� �޸���ͨ�û��߼�У��)
	 */
	public Boolean isOnlyRoot(Connection con, Integer userId) {
		Boolean result = false;
		try {
			String sql = "select * from user where id = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, userId);
			ResultSet rs = pre.executeQuery();
			// �����������߼��ж�����Ϊ��sql������ֻ����һ������
			if (rs.next()) {
				Integer role = Integer.parseInt(rs.getString("role"));
				if (ToolUtils.isSame(role, StatusOrTypeConstants.ROOT)) {
					// ��ǰ�û��ǹ���Ա
					Connection con1 = DBUtils.getConnection();
					if (getRootNumber(con) == 1) {
						//����Ա����Ϊ1
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

	//��ȡ����Ա�û�����
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
	 * �޸��û���Ϣ
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
	 * �����û���Ϣ
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
	 * �����û�����ѯ�û���Ϣ
	 * 
	 * @param con
	 * @param typeName
	 * @return
	 */
	public ResultSet listByUserName(Connection con, String userName) {
		ResultSet result = null;
		try {
			StringBuffer sb = new StringBuffer(
					"select id,if(role = 0,'��ͨ�û�','����Ա') role ,username,password,sex,phone from user");
			if (ToolUtils.isNotEmpty(userName)) {
				// �Ż���ֹsqlע��
				sb.append(" and username like ?");
			}
			PreparedStatement pre = con.prepareStatement(sb.toString().replace("and", "where"));
			if (ToolUtils.isNotEmpty(userName)) {
				pre.setString(1, "%" + userName + "%");
			}
			result = pre.executeQuery();
			// ����������ʱ���ر� pre ��ͬconһ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��¼��ȡ�û�
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

	// ע���û� ����û�
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
