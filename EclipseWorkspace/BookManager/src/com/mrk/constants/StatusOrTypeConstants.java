package com.mrk.constants;

public class StatusOrTypeConstants {
	/**
	 * 书籍状态
	 */
	public static final Integer NOT_BORROW = 0; // 可借阅
	public static final Integer ON_BORROW = 1;// 不可借阅

	/**
	 * 书籍状态筛选条件
	 */
	public static final String NOT_BORROW_STR = "可借阅"; // 可借阅
	public static final String ON_BORROW_STR = "不可借阅";// 不可借阅
	/**
	 * 书籍归还状态
	 */

	public static final Integer NOT_RETURN  = 0;// 未归还
	public static final Integer RETURND = 1;// 已归还
	/**
	 * 人员类别
	 */
	public static final Integer ORDINARY_USER = 0;// 普通用户
	public static final Integer ROOT = 1;// 管理员
	/**
	 * 人员类别筛选条件
	 */
	public static final String ORDINARY_USER_STR = "普通用户";// 普通用户
	public static final String ROOT_STR = "管理员";// 管理员
	
	/**
	 * 用户类别筛选条件
	 */
	public static final String USERNAME = "用户名";// 用户姓名
	/**
	 * 图书筛选条件
	 */
	public static final String SEARCH_BY_NAME = "书籍名称";//书籍名称
	public static final String SEARCH_BY_TYPE = "书籍类别";//书籍类型

	/**
	 * 借阅筛选条件
	 */
	public static final String NOT_TETURN_STR = "在借"; // 在借
	public static final String RETURND_STR = "已还"; //已还
	
	

}
