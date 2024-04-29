package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.dao.BorrowDetailsDao;
import com.mrk.dao.UserDao;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class RootMainFrame extends JFrame {
	private User logUser = null;
	// 子页面 书籍操作
	private BookInfoAddFrame bookInfoAddFrame;
	private BookInfoUpdateFrame bookInfoUpdateFrame;
	private BookInfoDeleteFrame bookInfoDeleteFrame;

	// 子页面 类别操作
	private TypeInfoAddFrame typeInfoAddFrame;
	private TypeInfoUpdateFrame typeInfoUpdateFrame;
	private TypeInfoDeleteFrame typeInfoDeleteFrame;

	// 子页面 用户操作
	private UserInfoAddFrame userInfoAddFrame;
	private UserInfoUpdateFrame userInfoUpdateFrame;
	private UserInfoDeleteFrame userInfoDeleteFrame;
	// Dao类
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BorrowDetailsDao borrowDetailsDao = new BorrowDetailsDao();
	private UserDao userDao = new UserDao();
	// 表格组件
	private JPanel contentPane;
	private JTable bookInfoTable;
	private JTable typeInfoTable;
	private JTable userInfoTable;
	private JTable borrowInfoTable;
	// 信息组件
	private JComboBox bookInfoComboBox;
	private JTextField bookInfoText;
	private JTextField typeInfoText;
	private JTextField userInfoText;
	private JComboBox borrowInfoCombBox;
	private JTextField borrowInfoText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RootMainFrame frame = new RootMainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RootMainFrame(User logUser) {

		this.logUser = logUser;// 设置当前登录用户

		setTitle("\u7BA1\u7406\u5458\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7BA1\u7406      ");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoAddActionPerformed(e); // 图书信息添加 操作
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u4FEE\u6539");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoUpdateActionPerformed(e);// 图书信息更改操作
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u5220\u9664");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoDeleteActionPerformed(e);// 图书信息删除操作
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("\u7C7B\u522B\u7BA1\u7406      ");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeInfoAddActionPerformed(e); // 类别信息添加 操作
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7C7B\u522B\u4FEE\u6539");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeInfoUpdateActionPerformed(e); // 类别信息修改 操作
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7C7B\u522B\u5220\u9664");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeInfoDetateActionPerformed(e); // 类别信息删除 操作
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_2 = new JMenu("\u7528\u6237\u7BA1\u7406      ");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u7528\u6237\u6DFB\u52A0");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInfoAddActionPerformed(e); // 用户信息添加 操作
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u7528\u6237\u4FEE\u6539");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInfoUpdateActionPerformed(e); // 用户信息修改 操作
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u7528\u6237\u5220\u9664");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInfoDeleteActionPerformed(e); // 用户信息删除 操作
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_3 = new JMenu("\u5B89\u5168\u9000\u51FA");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 退出系统事件操作
				secureLayOutActionPerformed(e);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_3.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("\u7C7B\u522B\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u4FE1\u606F");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("\u501F\u9605\u4FE1\u606F");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPane_1 = new JScrollPane();

		JScrollPane scrollPane_2 = new JScrollPane();

		JScrollPane scrollPane_3 = new JScrollPane();

		bookInfoComboBox = new JComboBox();
		bookInfoComboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		bookInfoComboBox.setModel(new DefaultComboBoxModel(new String[] { "\u4E66\u7C4D\u540D\u79F0",
				"\u4E66\u7C4D\u7C7B\u522B", "\u72B6\u6001(\u53EF\u501F\u9605/\u4E0D\u53EF\u501F\u9605)" }));

		bookInfoText = new JTextField();
		bookInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		bookInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 图书信息搜索事件
				searchBookInfoActionPerfromed(arg0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

		typeInfoText = new JTextField();
		typeInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeInfoText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 类型信息搜索事件
				searchTypeInfoActionPerfromed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));

		userInfoText = new JTextField();
		userInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		userInfoText.setColumns(10);

		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 用户信息搜索事件
				searchUserInfoActionPerfromed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));

		borrowInfoCombBox = new JComboBox();
		borrowInfoCombBox.setModel(new DefaultComboBoxModel(new String[] { "\u7528\u6237\u540D",
				"\u4E66\u7C4D\u540D\u79F0", "\u72B6\u6001(\u5728\u501F/\u5DF2\u8FD8)" }));
		borrowInfoCombBox.setFont(new Font("宋体", Font.PLAIN, 20));

		borrowInfoText = new JTextField();
		borrowInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		borrowInfoText.setColumns(10);

		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 借阅信息搜索事件
				searchBorrowInfoActionPerfromed(arg0);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane
								.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
										.addGap(57).addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
														.createSequentialGroup().addComponent(lblNewLabel_2).addGap(251)
														.addComponent(lblNewLabel_5).addGap(55)
														.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, 232,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 141,
																Short.MAX_VALUE)
														.addComponent(btnNewButton_2).addGap(219))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel_3).addGap(126)
														.addComponent(borrowInfoCombBox, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(53)
														.addComponent(borrowInfoText, GroupLayout.PREFERRED_SIZE, 235,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
														.addComponent(btnNewButton_3).addGap(217))
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(scrollPane_3, Alignment.LEADING)
														.addComponent(scrollPane, Alignment.LEADING)
														.addComponent(
																scrollPane_1, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
														.addGroup(Alignment.LEADING, gl_contentPane
																.createSequentialGroup()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(Alignment.LEADING, gl_contentPane
																				.createSequentialGroup()
																				.addComponent(lblNewLabel).addGap(65)
																				.addComponent(bookInfoComboBox,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(55).addComponent(bookInfoText,
																						GroupLayout.PREFERRED_SIZE, 230,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(Alignment.LEADING, gl_contentPane
																				.createSequentialGroup()
																				.addComponent(lblNewLabel_1).addGap(234)
																				.addComponent(lblNewLabel_4).addGap(51)
																				.addComponent(typeInfoText,
																						GroupLayout.PREFERRED_SIZE, 232,
																						GroupLayout.PREFERRED_SIZE)))
																.addGap(8)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addPreferredGap(
																						ComponentPlacement.RELATED, 128,
																						Short.MAX_VALUE)
																				.addComponent(btnNewButton).addGap(161))
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGap(130)
																				.addComponent(btnNewButton_1))))
														.addComponent(scrollPane_2, Alignment.LEADING))
														.addContainerGap(64, Short.MAX_VALUE)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(38)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(bookInfoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton).addComponent(bookInfoText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(btnNewButton_1).addComponent(lblNewLabel_4)
								.addComponent(typeInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(btnNewButton_2).addComponent(lblNewLabel_5)
								.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(32)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(btnNewButton_3)
								.addComponent(borrowInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(borrowInfoCombBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE)));

		borrowInfoTable = new JTable();
		borrowInfoTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7528\u6237\u540D",
				"\u4E66\u540D", "\u72B6\u6001", "\u501F\u4E66\u65F6\u95F4", "\u8FD8\u4E66\u65F6\u95F4" }));
		borrowInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		scrollPane_3.setViewportView(borrowInfoTable);

		userInfoTable = new JTable();
		userInfoTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
				"\u7528\u6237\u7C7B\u578B", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6027\u522B", "\u7535\u8BDD" }));
		userInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		scrollPane_2.setViewportView(userInfoTable);

		typeInfoTable = new JTable();
		typeInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u63CF\u8FF0" }));
		typeInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		scrollPane_1.setViewportView(typeInfoTable);

		bookInfoTable = new JTable();
		bookInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		bookInfoTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7", "\u4E66\u540D",
				"\u7C7B\u522B", "\u4F5C\u8005", "\u4EF7\u683C", "\u5E93\u5B58", "\u72B6\u6001" }));
		scrollPane.setViewportView(bookInfoTable);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);

		// 初始化管理端图书表格
		fillBookInfoTable(null, null, null);
		// 初始化图书类别表格信息
		fillTypeInfoTable(null);
		// 初始化用户表格信息
		fillUserInfoTable(null);
		// 初始化借阅表格信息
		fillBorrowInfoTable(null, null, null);
	}

	// 借阅信息搜索事件
	private void searchBorrowInfoActionPerfromed(ActionEvent arg0) {

		// 获取数据
		String searchStr = borrowInfoText.getText();
		String condition = (String) borrowInfoCombBox.getSelectedItem();
		if (ToolUtils.isSame(condition, StatusOrTypeConstants.USERNAME)) {
			// 按用户名搜索
			fillBorrowInfoTable(searchStr, null, null);
		} else if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_NAME)) {
			// 按书名搜索
			fillBorrowInfoTable(null, searchStr, null);
		} else {
			// 最后一种情况 按照条件查询 此分支中记得刷新
			if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.NOT_TETURN_STR)) {
				// 在借
				fillBorrowInfoTable(null, null, StatusOrTypeConstants.NOT_RETURN);
			} else if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.RETURND_STR)) {
				// 已还
				fillBorrowInfoTable(null, null, StatusOrTypeConstants.RETURND);
			} else {
				// 刷新
				fillBorrowInfoTable(null, null, null);
			}

		}

	}

	// 填充借阅表格信息方法
	public void fillBorrowInfoTable(String userName, String bookName, Integer status) {
		DefaultTableModel dtm = (DefaultTableModel) borrowInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			// 类别Dao方法返回数据结果集
			ResultSet rs = borrowDetailsDao.listByNameAndStatus(con, userName, bookName, status);
			while (rs.next()) {

				// user.username,book_name,IF(borrow_details.status = 0,'在借','已还')
				// STATUS,borrow_time,return_time
				Vector v = new Vector();
				v.add(rs.getString("user.username"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("status"));
				v.add(ToolUtils.getFarmatTime(rs.getLong("borrow_time")));
				v.add(ToolUtils.getFarmatTime(rs.getLong("return_time")));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 用户信息搜索事件
	private void searchUserInfoActionPerfromed(ActionEvent e) {

		// 获取数据
		String searchStr = userInfoText.getText();

		if (ToolUtils.isNotEmpty(searchStr)) {
			fillUserInfoTable(searchStr);
		} else {
			// 为空刷新
			fillUserInfoTable(null);
		}
	}

	// 填充用户表格信息方法
	public void fillUserInfoTable(String userName) {
		DefaultTableModel dtm = (DefaultTableModel) userInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			// 类别Dao方法返回数据结果集
			ResultSet rs = userDao.listByUserName(con, userName);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("role"));
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("phone"));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 类别搜索事件
	private void searchTypeInfoActionPerfromed(ActionEvent arg0) {

		// 获取数据
		String searchStr = typeInfoText.getText();

		if (ToolUtils.isNotEmpty(searchStr)) {
			fillTypeInfoTable(searchStr);
		} else {
			// 为空刷新
			fillTypeInfoTable(null);
		}
	}

	// 填充类别表格信息方法
	public void fillTypeInfoTable(String typeName) {
		DefaultTableModel dtm = (DefaultTableModel) typeInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			// 类别Dao方法返回数据结果集
			ResultSet rs = bookTypeDao.listByTypeName(con, typeName);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("remark"));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 图书信息搜索事件
	private void searchBookInfoActionPerfromed(ActionEvent arg0) {
		// 获取数据
		String searchStr = bookInfoText.getText();
		String condition = (String) bookInfoComboBox.getSelectedItem();
		if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_NAME)) {
			// 按书名搜索
			fillBookInfoTable(searchStr, null, null);
		} else if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_TYPE)) {
			// 按类别搜索
			fillBookInfoTable(null, searchStr, null);
		} else {
			// 最后一种情况 按照条件查询 此分支中记得刷新
			if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.NOT_BORROW_STR)) {
				// 可借阅
				fillBookInfoTable(null, null, StatusOrTypeConstants.NOT_BORROW);
			} else if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.ON_BORROW_STR)) {
				// 不可借阅
				fillBookInfoTable(null, null, StatusOrTypeConstants.ON_BORROW);
			} else {
				// 刷新
				fillBookInfoTable(null, null, null);
			}

		}

	}

	// 填充管理端图书表格信息
	public void fillBookInfoTable(String bookName, String typeName, Integer status) {
		DefaultTableModel dtm = (DefaultTableModel) bookInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			ResultSet rs = bookDao.listInfo(con, bookName, typeName, status);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("book.id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("author"));
				v.add(rs.getString("price"));
				v.add(rs.getInt("number"));
				v.add(rs.getString("status"));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 用户信息删除 操作
	private void userInfoDeleteActionPerformed(ActionEvent e) {
		if (userInfoAddFrame != null && userInfoAddFrame.isVisible()
				|| userInfoUpdateFrame != null && userInfoUpdateFrame.isVisible()
				|| userInfoDeleteFrame != null && userInfoDeleteFrame.isVisible()) {
			return;
		}
		userInfoDeleteFrame = new UserInfoDeleteFrame(this);
		userInfoDeleteFrame.setVisible(true);

	}

	// 用户信息修改 操作
	private void userInfoUpdateActionPerformed(ActionEvent e) {
		if (userInfoAddFrame != null && userInfoAddFrame.isVisible()
				|| userInfoUpdateFrame != null && userInfoUpdateFrame.isVisible()
				|| userInfoDeleteFrame != null && userInfoDeleteFrame.isVisible()) {
			return;
		}
		userInfoUpdateFrame = new UserInfoUpdateFrame(this);
		userInfoUpdateFrame.setVisible(true);

	}

	// 用户信息添加 操作
	private void userInfoAddActionPerformed(ActionEvent e) {
		if (userInfoAddFrame != null && userInfoAddFrame.isVisible()
				|| userInfoUpdateFrame != null && userInfoUpdateFrame.isVisible()
				|| userInfoDeleteFrame != null && userInfoDeleteFrame.isVisible()) {
			return;
		}
		userInfoAddFrame = new UserInfoAddFrame(this);
		userInfoAddFrame.setVisible(true);

	}

	// 类别信息删除 操作
	protected void typeInfoDetateActionPerformed(ActionEvent e) {
		if (typeInfoAddFrame != null && typeInfoAddFrame.isVisible()
				|| typeInfoUpdateFrame != null && typeInfoUpdateFrame.isVisible()
				|| typeInfoDeleteFrame != null && typeInfoDeleteFrame.isVisible()) {
			return;
		}
		typeInfoDeleteFrame = new TypeInfoDeleteFrame(this);
		typeInfoDeleteFrame.setVisible(true);

	}

	// 类别信息修改 操作
	private void typeInfoUpdateActionPerformed(ActionEvent e) {
		if (typeInfoAddFrame != null && typeInfoAddFrame.isVisible()
				|| typeInfoUpdateFrame != null && typeInfoUpdateFrame.isVisible()
				|| typeInfoDeleteFrame != null && typeInfoDeleteFrame.isVisible()) {
			return;
		}
		typeInfoUpdateFrame = new TypeInfoUpdateFrame(this);
		typeInfoUpdateFrame.setVisible(true);

	}

	// 类别信息添加 操作
	private void typeInfoAddActionPerformed(ActionEvent e) {
		if (typeInfoAddFrame != null && typeInfoAddFrame.isVisible()
				|| typeInfoUpdateFrame != null && typeInfoUpdateFrame.isVisible()
				|| typeInfoDeleteFrame != null && typeInfoDeleteFrame.isVisible()) {
			return;
		}
		typeInfoAddFrame = new TypeInfoAddFrame(this);
		typeInfoAddFrame.setVisible(true);

	}

	// 图书信息删除操作
	private void bookInfoDeleteActionPerformed(ActionEvent e) {
		if (bookInfoAddFrame != null && bookInfoAddFrame.isVisible()
				|| bookInfoUpdateFrame != null && bookInfoUpdateFrame.isVisible()
				|| bookInfoDeleteFrame != null && bookInfoDeleteFrame.isVisible()) {
			return;
		}
		bookInfoDeleteFrame = new BookInfoDeleteFrame(this);
		bookInfoDeleteFrame.setVisible(true);

	}

	// 图书信息更改操作
	private void bookInfoUpdateActionPerformed(ActionEvent e) {
		if (bookInfoAddFrame != null && bookInfoAddFrame.isVisible()
				|| bookInfoUpdateFrame != null && bookInfoUpdateFrame.isVisible()
				|| bookInfoDeleteFrame != null && bookInfoDeleteFrame.isVisible()) {
			return;
		}
		bookInfoUpdateFrame = new BookInfoUpdateFrame(this);
		bookInfoUpdateFrame.setVisible(true);

	}

	// 图书信息添加操作
	// 图书管理操作有且仅能存在一个
	private void bookInfoAddActionPerformed(ActionEvent e) {
		if (bookInfoAddFrame != null && bookInfoAddFrame.isVisible()
				|| bookInfoUpdateFrame != null && bookInfoUpdateFrame.isVisible()
				|| bookInfoDeleteFrame != null && bookInfoDeleteFrame.isVisible()) {
			return;
		}
		bookInfoAddFrame = new BookInfoAddFrame(this);
		bookInfoAddFrame.setVisible(true);
	}

	// 退出系统事件操作
	private void secureLayOutActionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统?");
		if (result == 0) {
			// 书籍信息管理页面退出
			if (bookInfoAddFrame != null && bookInfoAddFrame.isVisible()) {
				bookInfoAddFrame.dispose();
			}
			if (bookInfoUpdateFrame != null && bookInfoUpdateFrame.isVisible()) {
				bookInfoUpdateFrame.dispose();
			}
			if (bookInfoDeleteFrame != null && bookInfoDeleteFrame.isVisible()) {
				bookInfoDeleteFrame.dispose();
			}
			// 类别信息管理页面退出
			if (typeInfoAddFrame != null && typeInfoAddFrame.isVisible()) {
				typeInfoAddFrame.dispose();
			}
			if (typeInfoUpdateFrame != null && typeInfoUpdateFrame.isVisible()) {
				typeInfoUpdateFrame.dispose();
			}
			if (typeInfoDeleteFrame != null && typeInfoDeleteFrame.isVisible()) {
				typeInfoDeleteFrame.dispose();
			}
			// 用户信息管理页面退出
			if (userInfoAddFrame != null && userInfoAddFrame.isVisible()) {
				userInfoAddFrame.dispose();
			}
			if (userInfoUpdateFrame != null && userInfoUpdateFrame.isVisible()) {
				userInfoUpdateFrame.dispose();
			}
			if (userInfoDeleteFrame != null && userInfoDeleteFrame.isVisible()) {
				userInfoDeleteFrame.dispose();
			}
			// 管理员主页面关闭
			dispose();
		}

	}
}
