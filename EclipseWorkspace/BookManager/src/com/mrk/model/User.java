package com.mrk.model;
/**
 * ʵ����User
 * @author MrkWinter
 *
 */
public class User {
	private Integer id; // �Ñ�id
	private String userName; // �û���
	private String password; // �û�����
	private Integer role; // �û����� 0��ʾ��ͨ�û� 1��ʾ����Ա
	private String sex; // �û��Ա�
	private String phone; //�û��绰

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