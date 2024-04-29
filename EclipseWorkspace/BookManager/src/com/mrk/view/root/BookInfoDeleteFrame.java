package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.dao.BorrowDetailsDao;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;
import java.awt.event.MouseAdapter;

public class BookInfoDeleteFrame extends JFrame {
	// 主页面
	private RootMainFrame rootMainFrame;

	// Dao
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BorrowDetailsDao borrowDetailsDao = new BorrowDetailsDao();
	// 信息组件
	private JPanel contentPane;
	private JComboBox searchComboBox;
	private JTextField searchText;
	private JTable bookInfoTable;

	private JTextField bookIdText;
	private JTextField bookNameText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfoDeleteFrame frame = new BookInfoDeleteFrame();
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
	public BookInfoDeleteFrame(RootMainFrame rootMainFrame) {
		// 初始化主页面对象
		this.rootMainFrame = rootMainFrame;

		setTitle("\u56FE\u4E66\u5220\u9664\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u56FE\u4E66\u4FE1\u606F\u5220\u9664",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(26)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE)));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		bookIdText = new JTextField();
		bookIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		bookIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u4E66\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		bookNameText = new JTextField();
		bookNameText.setFont(new Font("宋体", Font.PLAIN, 20));
		bookNameText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除图书事件
				bookInfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(31).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addGap(43).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addGap(68).addComponent(btnNewButton_1).addContainerGap(72, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(27)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
						.addContainerGap(30, Short.MAX_VALUE)));
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
			public void actionPerformed(ActionEvent arg0) {
				// 删除界面搜索事件
				searchBookInfoActionPerfromed(arg0);
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
								.addGroup(gl_panel.createSequentialGroup().addGap(52).addComponent(lblNewLabel)
										.addGap(28)
										.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(38)
										.addComponent(searchText, GroupLayout.PREFERRED_SIZE, 155,
												GroupLayout.PREFERRED_SIZE)
										.addGap(37).addComponent(btnNewButton))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton).addComponent(lblNewLabel))
				.addGap(12).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
				.addContainerGap()));

		bookInfoTable = new JTable();
		bookInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// 表格点击事件
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

		// 初始化删除界面图书表格信息
		fillBookInfoTable(null, null, null);
	}

	// 删除图书事件
	private void bookInfoDeleteActionPerformed(ActionEvent e) {

		// 1. 获取信息
		String bookId = bookIdText.getText();
		String bookName = bookNameText.getText();
		// 2. 校验信息
		if (ToolUtils.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "编号不能为空！");
			return;
		} else if (ToolUtils.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "书名不能为空！");
			return;
		} else if (!ToolUtils.isPositiveInteger(bookId)) {
			JOptionPane.showMessageDialog(null, "编号格式有误！");
		}
		Integer bookIdInt = Integer.parseInt(bookId);
		
		//二次确认
		int result = JOptionPane.showConfirmDialog(null, "是否删除?(无法恢复)");
		if (result != 0) {
			return;
		}
		
		// 3. 执行操作
		// 1. 执行前先判断该书是否有未还的借书记录 如果有 则不能删除
		Connection con = DBUtils.getConnection();
		if (borrowDetailsDao.isExistBorrowByBookId(con, bookIdInt)) {
			JOptionPane.showMessageDialog(null, "该书籍有未归还的记录 请处理完毕后再进行删除！");
			return;
		}
		
		Boolean result1 = bookDao.deleteByIdAndName(con, bookIdInt, bookName);
		if(result1) {
			JOptionPane.showMessageDialog(null, "删除成功！");
		// 4. 刷新当前窗口图书查询列表
			fillBookInfoTable(null, null, null);
		// 5.刷新主页面图书查询列表
			rootMainFrame.fillBookInfoTable(null, null, null);
		// 6.重置文本数据
			resetUpdateBookInfo();
		} else {
			JOptionPane.showMessageDialog(null, "删除失败 请检查删除信息！");
			return;
		}

	}

	// 重置输入文本信息
	private void resetUpdateBookInfo() {
		bookIdText.setText("");
		bookNameText.setText("");
	}

	/*
	 * 表格行点击事件处理
	 */
	private void bookInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = bookInfoTable.getSelectedRow();
		// 修改信息组件
		bookIdText.setText((String) bookInfoTable.getValueAt(row, 0));
		bookNameText.setText((String) bookInfoTable.getValueAt(row, 1));
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

	// 填充管理端删除界面图书表格信息
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
