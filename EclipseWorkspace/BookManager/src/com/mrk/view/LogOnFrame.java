package com.mrk.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.UserDao;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;
import com.mrk.view.User.UserMainFramed;
import com.mrk.view.root.RootMainFrame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * 图书管理系统登录页面
 * 
 * @author MrkWinter
 *
 */
public class LogOnFrame extends JFrame {

	private UserDao userDao = new UserDao();
	private JPanel contentPane;
	private JTextField userNameTextFiled;
	private JPasswordField passwordTextFiled;
	private JComboBox premComBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// 改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}

		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrame frame = new LogOnFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnFrame() {


		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u767B\u5F55");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		userNameTextFiled = new JTextField();
		userNameTextFiled.setFont(new Font("宋体", Font.PLAIN, 20));
		userNameTextFiled.setColumns(10);

		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setFont(new Font("宋体", Font.PLAIN, 20));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				loginActionPerformed(arg1);
			}
		});

		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 20));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});

		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		registerButton.setFont(new Font("宋体", Font.PLAIN, 20));

		passwordTextFiled = new JPasswordField();
		passwordTextFiled.setFont(new Font("宋体", Font.PLAIN, 20));

		this.premComBox = new JComboBox();
		premComBox.setFont(new Font("宋体", Font.PLAIN, 20));
		premComBox.setModel(new DefaultComboBoxModel(new String[] { "\u7528\u6237", "\u7BA1\u7406\u5458" }));

		JLabel lblNewLabel_3 = new JLabel("\u6743  \u9650");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(loginButton)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTextFiled, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(premComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordTextFiled, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
							.addGap(205))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(91)
							.addComponent(resetButton)
							.addGap(94)
							.addComponent(registerButton)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(270))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(userNameTextFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTextFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(premComBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton)
						.addComponent(registerButton))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
	}
	/*
	 * 用户注册 - 只能注册普通用户
	 */
	private void registerActionPerformed(ActionEvent e) {
		dispose();
		new RegisterFrame().setVisible(true);
	}

	/*
	 * 登录事件处理
	 */
	private void loginActionPerformed(ActionEvent arg) {
		String userName = this.userNameTextFiled.getText();
		String password = new String(this.passwordTextFiled.getPassword());
		if (ToolUtils.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		} else if (ToolUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		// 连接查询数据库
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		Connection con = DBUtils.getConnection();
		User logUser = userDao.login(con, user);

		String prem = (String) this.premComBox.getSelectedItem();
		if (logUser != null
				&& (("用户".equals(prem) && logUser.getRole() == StatusOrTypeConstants.ORDINARY_USER)
						|| ("管理员".equals(prem) && logUser.getRole() == StatusOrTypeConstants.ROOT))) {
			JOptionPane.showMessageDialog(null, "登录成功");
			dispose();
			if(logUser.getRole() == StatusOrTypeConstants.ORDINARY_USER) {
				//用户界面
				UserMainFramed userMainFramed = new UserMainFramed(logUser);
				userMainFramed.setVisible(true);
			} else {
				//管理员界面
				RootMainFrame rootMainFrame = new RootMainFrame(logUser);
				rootMainFrame.setVisible(true);

			}
			
		} else {
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
		}

	}

	/*
	 * 重置文本事件处理
	 */
	private void resetValueActionPerformed(ActionEvent arg) {
		this.userNameTextFiled.setText("");
		this.passwordTextFiled.setText("");
	}
}
