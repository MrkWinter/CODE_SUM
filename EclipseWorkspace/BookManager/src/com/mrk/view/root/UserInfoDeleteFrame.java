package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.UserDao;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class UserInfoDeleteFrame extends JFrame {
	// 主页面
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	// Dao
	private UserDao userDao = new UserDao();
	// 搜索组件
	private JTextField userInfoText;
	private JTable userInfoTable;
	// 信息组件
	private JTextField userIdText;
	private JTextField usernameText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserInfoDeleteFrame frame = new UserInfoDeleteFrame();
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
	public UserInfoDeleteFrame(RootMainFrame rootMainFrame) {
		// 初始化主页面对象
		this.rootMainFrame = rootMainFrame;

		setTitle("\u7528\u6237\u4FE1\u606F\u5220\u9664");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7528\u6237\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7528\u6237\u4FE1\u606F\u5220\u9664", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		userIdText = new JTextField();
		userIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		userIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		usernameText = new JTextField();
		usernameText.setFont(new Font("宋体", Font.PLAIN, 20));
		usernameText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除用户信息事件
				userInfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(51).addComponent(lblNewLabel_1).addGap(18)
						.addComponent(userIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(47).addComponent(lblNewLabel_2).addGap(18)
						.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addGap(64).addComponent(btnNewButton_1).addContainerGap(95, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(userIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		userInfoText = new JTextField();
		userInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		userInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 用户删除窗口 用户信息搜索事件
				searchUserInfoActionPerfromed(arg0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(112).addComponent(lblNewLabel).addGap(49)
								.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGap(69).addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE).addContainerGap()));

		userInfoTable = new JTable();
		userInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// 表格行点击事件处理
				userInfoTablePressedToGetInfo(arg0);
			}
		});
		userInfoTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
				"\u7528\u6237\u7C7B\u578B", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6027\u522B", "\u7535\u8BDD" }));
		userInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		scrollPane.setViewportView(userInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// 窗口居中
		// 填充用户表格信息方法
		fillUserInfoTable(null);
	}

	// 删除用户界面 删除用户信息事件
	private void userInfoDeleteActionPerformed(ActionEvent e) {
		// 1. 获取数据
		String userId = userIdText.getText();
		String username = usernameText.getText();
		// 2. 校验数据
		if (ToolUtils.isEmpty(userId)) {
			JOptionPane.showMessageDialog(null, "编号不能为空！");
			return;
		} else if (ToolUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		} else if (!ToolUtils.isPositiveInteger(userId)) {
			JOptionPane.showMessageDialog(null, "编号格式有误！");
			return;
		}
		// 二次确认
		int result = JOptionPane.showConfirmDialog(null, "是否删除?(无法恢复)");
		if (result != 0) {
			return;
		}

		// 3. 检测是否可以删除
		Integer userIdInt = Integer.parseInt(userId);
		Connection con = DBUtils.getConnection();
		Boolean isOnlyRoot = userDao.isOnlyRoot(con, userIdInt);
		if (isOnlyRoot) {
			JOptionPane.showMessageDialog(null, "此用户为唯一管理员，系统不允许删除 ！");
			return;
		}
		// 4. 实施操作
		Connection con1 = DBUtils.getConnection();
		Boolean isDelete = userDao.deleteByIdAndName(con1, userIdInt, username);
		if (isDelete) {
			JOptionPane.showMessageDialog(null, "删除成功！");
			// 5. 重置输入数据
			resetDeleteUserInfo();
			// 6. 刷新删除页面用户数据
			fillUserInfoTable(null);
			// 7. 刷新主页面用户数据
			rootMainFrame.fillUserInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "删除失败 请检查删除信息！");
			return;
		}
	}

	/*
	 * 表格行点击事件处理
	 */
	private void userInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = userInfoTable.getSelectedRow();
		// 修改信息组件
		userIdText.setText((String) userInfoTable.getValueAt(row, 0));
		usernameText.setText((String) userInfoTable.getValueAt(row, 2));
	}

	/**
	 * 重置删除用户信息界面 文本信息方法
	 */
	private void resetDeleteUserInfo() {
		userIdText.setText("");
		usernameText.setText("");
	}

	// 用户删除窗口 用户信息搜索事件
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
				v.add(rs.getString("id"));
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
}
