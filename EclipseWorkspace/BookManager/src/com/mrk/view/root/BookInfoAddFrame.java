package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.model.Book;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class BookInfoAddFrame extends JFrame {

	//主页面
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	// Dao
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	// 获取信息组件
	private JTextField bookNameText;
	private JTextField authorText;
	private JTextField publisherText;
	private JTextField priceText;
	private JTextField numberText;
	private JComboBox typeComboBox;
	private JTextArea remarkTArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfoAddFrame frame = new BookInfoAddFrame();
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
	public BookInfoAddFrame(RootMainFrame rootMainFrame) {
		//初始化主页面对象
		this.rootMainFrame = rootMainFrame;
		
		setTitle("\u56FE\u4E66\u6DFB\u52A0\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u6DFB\u52A0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("\u51FA\u7248\u793E");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("\u4EF7\u683C");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("\u5E93\u5B58");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_6 = new JLabel("\u7C7B\u522B");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));

		bookNameText = new JTextField();
		bookNameText.setFont(new Font("宋体", Font.PLAIN, 20));
		bookNameText.setColumns(10);

		authorText = new JTextField();
		authorText.setFont(new Font("宋体", Font.PLAIN, 20));
		authorText.setColumns(10);

		publisherText = new JTextField();
		publisherText.setFont(new Font("宋体", Font.PLAIN, 20));
		publisherText.setColumns(10);

		priceText = new JTextField();
		priceText.setFont(new Font("宋体", Font.PLAIN, 20));
		priceText.setColumns(10);

		numberText = new JTextField();
		numberText.setFont(new Font("宋体", Font.PLAIN, 20));
		numberText.setColumns(10);

		remarkTArea = new JTextArea();
		remarkTArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		remarkTArea.setForeground(new Color(0, 0, 0));

		typeComboBox = new JComboBox();
		typeComboBox.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 添加图书事件
				addBookActionPerformed(arg0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//重置信息
				resetBookAddInfoActionPerformed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(283).addComponent(lblNewLabel)
						.addContainerGap(305, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(62)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_5).addComponent(lblNewLabel_7))
						.addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(144)
										.addComponent(btnNewButton_1).addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(publisherText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(remarkTArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														381, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING)
														.addComponent(numberText, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED, 90,
																Short.MAX_VALUE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNewLabel_4).addComponent(lblNewLabel_6)
																.addComponent(lblNewLabel_2))
														.addGap(31)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(authorText, GroupLayout.DEFAULT_SIZE, 114,
																		Short.MAX_VALUE)
																.addComponent(priceText).addComponent(typeComboBox, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addGap(110)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(81).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2).addComponent(authorText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(30)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(publisherText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4).addComponent(priceText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(numberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6).addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_7)
						.addComponent(remarkTArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(32).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		// 设置文本域边框
		remarkTArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));

		this.setLocationRelativeTo(null);// 窗口居中

		fillTypeComboBox();// 初始化下拉框数据
	}

	/*
	 * 重置添加图书的信息
	 */
	private void resetBookAddInfoActionPerformed(ActionEvent arg0) {
		resetAddBookInfo();
	}

	/*
	 * 添加图书事件
	 */
	private void addBookActionPerformed(ActionEvent arg0) {
		// 1. 获取检验数据
		String bookName = bookNameText.getText();
		String author = authorText.getText();
		String publish = publisherText.getText();
		String price = priceText.getText();
		String number = numberText.getText();
		// 因为下拉框初始化时加入的就是BookType对象 所以这里直接强转
		BookType bookType = (BookType) typeComboBox.getSelectedItem();
		String remark = remarkTArea.getText();
		// 校验数据
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
		Double priceDou = Double.parseDouble(price);
		Integer numberInt = Integer.parseInt(number);
		//封装数据
		Book insertBook = new Book(bookName,bookType.getId(),author,publish,priceDou,numberInt,StatusOrTypeConstants.ON_BORROW,remark);
		// 2. 尝试插入数据 默认状态设置为不可借阅
		Connection con = DBUtils.getConnection();
		Boolean result = bookDao.add(con, insertBook);
		if(result) {
			//成功
			JOptionPane.showMessageDialog(null, "添加成功！");
			
			resetAddBookInfo();
			// 3.插入成功后重置选择信息内容 -- 封装方法
			resetAddBookInfo();
			// 4.刷新主页面展示图书的信息
			rootMainFrame.fillBookInfoTable(null,null,null);
		} else {
			JOptionPane.showMessageDialog(null, "添加失败 系统错误！");
			return;
		}
	}

	//重置文本信息
	private void resetAddBookInfo() {
		bookNameText.setText("");
		authorText.setText("");
		publisherText.setText("");
		priceText.setText("");
		numberText.setText("");
		if (typeComboBox.getItemCount() > 0) {
			typeComboBox.setSelectedIndex(0); // 如果有选择第一个选项
		}
		remarkTArea.setText("");
	}

	/*
	 * 初始化图书添加种类下拉框
	 */
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
				this.typeComboBox.addItem(bookType);
			}
			DBUtils.close(rs, null, con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
