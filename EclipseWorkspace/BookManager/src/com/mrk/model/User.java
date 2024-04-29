package com.mrk.model;
/**
 * 实体类User
 * @author MrkWinter
 *
 */
public class User {
	private Integer id; // 用戶id
	private String userName; // 用户名
	private String password; // 用户密码
	private Integer role; // 用户类型 0表示普通用户 1表示管理员
	private String sex; // 用户性别
	private String phone; //用户电话

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String userName, String password, Integer role, String sex, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.phone = phone;
	}

}