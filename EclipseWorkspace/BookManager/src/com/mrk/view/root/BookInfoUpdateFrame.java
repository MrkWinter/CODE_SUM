package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.model.Book;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookInfoUpdateFrame extends JFrame {
	// 主页面
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	// Dao
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	// 搜索信息组件
	private JTextField searchText;
	private JComboBox searchComboBox;
	private JTable bookInfoTable;
	// 修改信息组件
	private JTextField bookIdText;
	private JTextField bookNameText;
	private JTextField authorText;
	private JComboBox bookTypeComboBox;
	private JTextField publishText;
	private JTextField priceText;
	private JTextField numberText;
	private JComboBox statusComboBox;
	private JTextArea remarkTArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfoUpdateFrame frame = new BookInfoUpdateFrame();
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
	public BookInfoUpdateFrame(RootMainFrame rootMainFrame) {
		// 初始化主页面对象
		this.rootMainFrame = rootMainFrame;

		setTitle("\u56FE\u4E66\u4FEE\u6539\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 939, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(37)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7  ");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		bookIdText = new JTextField();
		bookIdText.setEditable(false);
		bookIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		bookIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u4E66\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		bookNameText = new JTextField();
		bookNameText.setFont(new Font("宋体", Font.PLAIN, 20));
		bookNameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

		authorText = new JTextField();
		authorText.setFont(new Font("宋体", Font.PLAIN, 20));
		authorText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u7C7B\u522B");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

		bookTypeComboBox = new JComboBox();
		bookTypeComboBox.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("\u51FA\u7248\u793E");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));

		publishText = new JTextField();
		publishText.setFont(new Font("宋体", Font.PLAIN, 20));
		publishText.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));

		priceText = new JTextField();
		priceText.setFont(new Font("宋体", Font.PLAIN, 20));
		priceText.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("\u5E93\u5B58");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));

		numberText = new JTextField();
		numberText.setFont(new Font("宋体", Font.PLAIN, 20));
		numberText.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("\u72B6\u6001");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 20));

		statusComboBox = new JComboBox();
		statusComboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		statusComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "\u53EF\u501F\u9605", "\u4E0D\u53EF\u501F\u9605" }));

		JLabel lblNewLabel_9 = new JLabel("\u63CF\u8FF0");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 20));

		remarkTArea = new JTextArea();
		remarkTArea.setFont(new Font("Monospaced", Font.PLAIN, 18));

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 修改信息事件
				bookInfoUpdateActionPerformed(arg0);
			}
		});

		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 重置输入文本信息事件
				resetUpdateBookInfoActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_9).addComponent(lblNewLabel_1))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addComponent(publishText)
								.addComponent(bookIdText, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(bookNameText, Alignment.LEADING).addComponent(priceText,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
						.addComponent(remarkTArea, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
				.addGap(30)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3).addComponent(lblNewLabel_7))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(numberText, 168, 168, Short.MAX_VALUE).addComponent(btnNewButton_1)
						.addComponent(authorText))
				.addGap(33)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_8))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(statusComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(bookTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(btnNewButton_2))
				.addGap(69)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(
						30)
				.addGroup(
						gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
								.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4).addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(publishText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(numberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8).addComponent(statusComboBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_9)
						.addComponent(remarkTArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2).addComponent(btnNewButton_1))
				.addContainerGap(326, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("\u641C\u7D22\u6761\u4EF6");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] { "\u4E66\u7C4D\u540D\u79F0",
				"\u4E66\u7C4D\u7C7B\u522B", "\u72B6\u6001(\u53EF\u501F\u9605/\u4E0D\u53EF\u501F\u9605)" }));
		searchComboBox.setFont(new Font("宋体", Font.PLAIN, 20));

		searchText = new JTextField();
		searchText.setFont(new Font("宋体", Font.PLAIN, 20));
		searchText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询图书信息事件
				searchBookInfoActionPerfromed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(116).addComponent(lblNewLabel)
										.addGap(48)
										.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(48)
										.addComponent(searchText, GroupLayout.PREFERRED_SIZE, 155,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(btnNewButton))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)
										.addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addContainerGap()));

		bookInfoTable = new JTable();
		bookInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// 鼠标点击表格数据事件 由此事件将表格中的某一行数据加入到需要修改图书输入的文本信息中去 简化操作
				bookInfoTablePressedToGetInfo(arg0);
			}
		});
		bookInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		bookInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u4E66\u540D", "\u7C7B\u522B", "\u4F5C\u8005", "\u51FA\u7248\u793E",
						"\u4EF7\u683C", "\u5E93\u5B58", "\u72B6\u6001", "\u63CF\u8FF0" }));
		scrollPane.setViewportView(bookInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// 窗口居中

		// 设置文本域边框
		remarkTArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
		// 初始化修改图书表格信息
		fillBookInfoTable(null, null, null);
		// 初始化修改信息类别下拉框
		fillTypeComboBox();

	}

	// 修改信息事件
	private void bookInfoUpdateActionPerformed(ActionEvent arg0) {
		// 1. 获取信息
		String bookId = bookIdText.getText();
		String bookName = bookNameText.getText();
		String author = authorText.getText();
		// 下拉框 - 类型
		BookType bookType = (BookType) bookTypeComboBox.getSelectedItem();

		String publish = publishText.getText();
		String price = priceText.getText();
		String number = numberText.getText();
		// 下拉框 - 状态
		String status = (String) statusComboBox.getSelectedItem();
		Integer statusInt = null;
		if (ToolUtils.isSame(status, StatusOrTypeConstants.NOT_BORROW_STR)) {
			// 可借阅
			statusInt = 0;
		} else {
			// 不可借阅
			statusInt = 1;
		}

		String remark = remarkTArea.getText();
		// 2. 校验数据
		if (ToolUtils.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "书名信息不能为空！");
			return;
		} else if (ToolUtils.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者信息不能为空！");
			return;
		} else if (ToolUtils.isEmpty(publish)) {
			JOptionPane.showMessageDialog(null, "出版社信息不能为空！");
			return;
		} else if (ToolUtils.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格信息不能为空！");
			return;
		} else if (ToolUtils.isEmpty(number)) {
			JOptionPane.showMessageDialog(null, "库存信息不能为空！");
			return;
		} else if (ToolUtils.isEmpty(bookType)) {
			JOptionPane.showMessageDialog(null, "类别信息不能为空！");
			return;
		} else if (ToolUtils.isEmpty(remark)) {
			JOptionPane.showMessageDialog(null, "图书描述信息不能为空！");
			return;
		} else if (!ToolUtils.isPositiveNumber(price)) {
			JOptionPane.showMessageDialog(null, "价格信息格式有误！");
			return;
		} else if (!ToolUtils.isPositiveInteger(number)) {
			JOptionPane.showMessageDialog(null, "库存信息格式有误！");
			return;
		}
		Integer bookIdInt = Integer.parseInt(bookId);
		Double priceDou = Double.parseDouble(price);
		Integer numberInt = Integer.parseInt(number);
		// 3. 封装信息
		Book updateBook = new Book(bookName, bookType.getId(), author, publish, priceDou, numberInt, statusInt, remark);
		updateBook.setId(bookIdInt);

		// 4. 执行操作
		Connection con = DBUtils.getConnection();
		Boolean result = bookDao.updateById(con, updateBook);
		if (result) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			// 5. 清空输入文本信息
			resetUpdateBookInfo();
			// 6. 刷新当前页面图书搜索信息
			fillBookInfoTable(null, null, null);
			// 7. 刷新主页面图书搜素信息
			this.rootMainFrame.fillBookInfoTable(null, null, null);
		} else {
			JOptionPane.showMessageDialog(null, "修改失败 系统错误！");
			return;
		}

	}

	/*
	 * 初始化修改信息类别下拉框
	 */

	// 重置输入文本信息事件
	private void resetUpdateBookInfoActionPerformed(ActionEvent e) {
		resetUpdateBookInfo();
	}

	// 重置输入文本信息
	private void resetUpdateBookInfo() {

		bookIdText.setText("");
		bookNameText.setText("");
		authorText.setText("");
		if (bookTypeComboBox.getSelectedIndex() != -1) { // 有选项被选中
			bookTypeComboBox.setSelectedIndex(0);
		}
		publishText.setText("");
		priceText.setText("");
		numberText.setText("");
		if (statusComboBox.getSelectedIndex() != -1) { // 有选项被选中
			statusComboBox.setSelectedIndex(0);
		}
		remarkTArea.setText("");
	}

	// 填充种类选项
	private void fillTypeComboBox() {
		try {
			Connection con = DBUtils.getConnection();
			// 这里复用list方法 如果传入名为空则返回所有类别数据的result对象
			ResultSet rs = bookTypeDao.listByTypeName(con, null);
			BookType bookType = null;
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setTypeName(rs.getString("type_name"));
				// 这里在下拉框中添加对象 目的是在获取数据时可以直接获取对应类别的id 便于图书插入操作
				// 下拉框展示对象数据时会调用toString方法 这里已经重写该方法 故展示的为类别信息
				this.bookTypeComboBox.addItem(bookType);
			}
			DBUtils.close(rs, null, con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 表格行点击事件处理
	 */
	private void bookInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = bookInfoTable.getSelectedRow();
		// 修改信息组件
		bookIdText.setText((String) bookInfoTable.getValueAt(row, 0));
		bookNameText.setText((String) bookInfoTable.getValueAt(row, 1));
		authorText.setText((String) bookInfoTable.getValueAt(row, 3));
		// 种类框架 设置 对接需要从写equals方法
		String bookTypeStr = (String) bookInfoTable.getValueAt(row, 2);
		BookType bookType = new BookType(bookTypeStr, null);
		bookTypeComboBox.setSelectedItem(bookType);

		publishText.setText((String) bookInfoTable.getValueAt(row, 4));
		priceText.setText((String) bookInfoTable.getValueAt(row, 5));
		numberText.setText((String) bookInfoTable.getValueAt(row, 6));
		// 状态框设置
		String status = (String) bookInfoTable.getValueAt(row, 7);
		statusComboBox.setSelectedItem(status);

		remarkTArea.setText((String) bookInfoTable.getValueAt(row, 8));
	}

	// 图书信息搜索事件
	private void searchBookInfoActionPerfromed(ActionEvent arg0) {
		// 获取数据
		String searchStr = searchText.getText();
		String condition = (String) searchComboBox.getSelectedItem();
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

	// 填充管理端修改图书表格信息
	public void fillBookInfoTable(String bookName, String typeName, Integer status) {
		DefaultTableModel dtm = (DefaultTableModel) bookInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			ResultSet rs = bookDao.listUpdateInfo(con, bookName, typeName, status);
			while (rs.next()) {
				Vector v = new Vector();
				// 这里全部转换成String 便于后面操作
				v.add(rs.getString("book.id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("author"));
				v.add(rs.getString("publish"));
				v.add(rs.getString("price"));
				v.add(rs.getString("number"));
				v.add(rs.getString("status"));
				v.add(rs.getString("book.remark"));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
