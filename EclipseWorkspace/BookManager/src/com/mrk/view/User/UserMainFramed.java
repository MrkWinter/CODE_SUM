package com.mrk.view.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BorrowDetailsDao;
import com.mrk.model.BorrowDetails;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserMainFramed extends JFrame {

	private JPanel contentPane;
	private ReturnBookFrame returnBookFrame;
	private BorrowBookFramed borrowBookFramed;
	private User logUser = null;
	private BookDao bookDao = new BookDao();
	private BorrowDetailsDao borrowDetailsDao = new BorrowDetailsDao();
	private JTextField searchText;
	private JComboBox searchComboBox;
	private JTable bookInfoTable;
	private JTable borrowDetailsTable;
	private JTextField borrowSearchText;
	private JComboBox borrowComboBox;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserMainFramed frame = new UserMainFramed();
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
	public UserMainFramed(User logUser) {

		this.logUser = logUser; // 设置当前登录用户

		setTitle("\u7528\u6237\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("\u53EF\u501F\u9605\u56FE\u4E66\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));

		searchComboBox = new JComboBox();
		searchComboBox.setModel(
				new DefaultComboBoxModel(new String[] {"\u4E66\u7C4D\u540D\u79F0", "\u4E66\u7C4D\u7C7B\u522B"}));
		searchComboBox.setFont(new Font("宋体", Font.PLAIN, 20));

		searchText = new JTextField();
		searchText.setFont(new Font("宋体", Font.PLAIN, 20));
		searchText.setColumns(10);

		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchByBookNameOrType(arg0);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("\u5DF2\u501F\u9605\u56FE\u4E66\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));

		borrowComboBox = new JComboBox();
		borrowComboBox.setModel(
				new DefaultComboBoxModel(new String[] {"\u4E66\u7C4D\u540D\u79F0", "\u501F\u9605\u72B6\u6001(\u5728\u501F/\u5DF2\u8FD8)"}));
		borrowComboBox.setFont(new Font("宋体", Font.PLAIN, 20));

		borrowSearchText = new JTextField();
		borrowSearchText.setFont(new Font("宋体", Font.PLAIN, 20));
		borrowSearchText.setColumns(10);

		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchBorrowDetailsActionPerformed(arg0);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(44).addGroup(gl_contentPane
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1).addGap(85)
										.addComponent(borrowComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(62)
										.addComponent(borrowSearchText, GroupLayout.PREFERRED_SIZE, 193,
												GroupLayout.PREFERRED_SIZE)
										.addGap(86).addComponent(btnNewButton_4).addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(scrollPane_1, Alignment.LEADING)
												.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														945, Short.MAX_VALUE)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel).addGap(79)
														.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(60)
														.addComponent(searchText, GroupLayout.PREFERRED_SIZE, 198,
																GroupLayout.PREFERRED_SIZE)
														.addGap(82).addComponent(btnNewButton_3)))
										.addGap(57)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(62)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_3)
								.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(32).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
				.addGap(73)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(borrowSearchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(borrowComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4))
				.addGap(34).addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(53, Short.MAX_VALUE)));

		borrowDetailsTable = new JTable();
		borrowDetailsTable.setFont(new Font("宋体", Font.PLAIN, 19));
		borrowDetailsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u501F\u9605\u7F16\u53F7", "\u4E66\u540D", "\u72B6\u6001", "\u501F\u4E66\u65F6\u95F4", "\u8FD8\u4E66\u65F6\u95F4"
			}
		));
		scrollPane_1.setViewportView(borrowDetailsTable);

		bookInfoTable = new JTable();
		bookInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		bookInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u540D", "\u7C7B\u522B", "\u4F5C\u8005", "\u6982\u8FF0"
			}
		));
		scrollPane.setViewportView(bookInfoTable);

		JButton btnNewButton = new JButton("\u501F\u4E66\u64CD\u4F5C        ");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBookActionPerformed(e);
			}
		});
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u8FD8\u4E66\u64CD\u4F5C        ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBookActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u5B89\u5168\u9000\u51FA        ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secureLayOutActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		toolBar.add(btnNewButton_2);
		contentPane.setLayout(gl_contentPane);

		fillBookTable(null, null);// 初始化填充表 未限制条件
		fillBorrowTable(null, null); // 初始化填充表 未限制条件
		this.setLocationRelativeTo(null);

	}

	// 借阅信息条件搜索事件
	private void searchBorrowDetailsActionPerformed(ActionEvent arg0) {
		String searchStr = borrowSearchText.getText();
		String condition = (String) borrowComboBox.getSelectedItem();
		if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_NAME)) {
			// 按书名搜索
			fillBorrowTable(searchStr, null);
		} else {
			// 按类别搜索 因为condition字符串复杂所以不进行比较
			if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.NOT_TETURN_STR)) {
				// 在借阅
				fillBorrowTable(null, StatusOrTypeConstants.NOT_RETURN);
			} else if(ToolUtils.isSame(searchStr, StatusOrTypeConstants.RETURND_STR)){
				// 已归还
				fillBorrowTable(null, StatusOrTypeConstants.RETURND);
			} else {
				//输入错误关键字就刷新
				//刷新
				fillBorrowTable(null, null);
			}
		}
	}

	// 图书条件搜索事件
	private void searchByBookNameOrType(ActionEvent arg0) {

		String searchStr = searchText.getText();
		String condition = (String) searchComboBox.getSelectedItem();
		if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_NAME)) {
			// 按书名搜索
			fillBookTable(searchStr, null);
		} else if(ToolUtils.isSame(condition,StatusOrTypeConstants.SEARCH_BY_TYPE)){
			// 按类别搜索
			fillBookTable(null, searchStr);
		} else {
			//刷新
			fillBookTable(null, null);
		}
	}

	// 填充图书信息表
	private void fillBookTable(String bookName, String typeName) {
		DefaultTableModel dtm = (DefaultTableModel) bookInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			ResultSet rs = bookDao.list(con, bookName, typeName,StatusOrTypeConstants.NOT_BORROW);
			while (rs.next()) {

				Vector v = new Vector();
				v.add(rs.getInt("book.id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("author"));
				v.add(rs.getString("book.remark"));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 填充借书信息
	private void fillBorrowTable(String bookName, Integer status) {
		DefaultTableModel dtm = (DefaultTableModel) borrowDetailsTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			ResultSet rs = borrowDetailsDao.list(con, bookName, status, logUser.getId());
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("borrow_details.id"));
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

	// 还书操作 页面
	private void returnBookActionPerformed(ActionEvent e) {
		if (logUser == null || (returnBookFrame != null && returnBookFrame.isVisible())
				|| (borrowBookFramed != null && borrowBookFramed.isVisible()))
			return;
		returnBookFrame = new ReturnBookFrame(logUser);
		returnBookFrame.setVisible(true);
	}

	// 借书操作 页面
	private void borrowBookActionPerformed(ActionEvent e) {
		if (logUser == null || (borrowBookFramed != null && borrowBookFramed.isVisible())
				|| (returnBookFrame != null && returnBookFrame.isVisible()))
			return;
		borrowBookFramed = new BorrowBookFramed(logUser);
		borrowBookFramed.setVisible(true);
	}

	// 退出系统事件操作
	private void secureLayOutActionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统?");
		if (result == 0) {
			if(borrowBookFramed != null && borrowBookFramed.isVisible()) {
				borrowBookFramed.dispose();
			}
			if(returnBookFrame != null && returnBookFrame.isVisible()) {
				returnBookFrame.dispose();
			}
			dispose();
		}

	}
}
