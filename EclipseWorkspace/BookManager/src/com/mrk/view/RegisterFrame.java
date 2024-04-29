package com.mrk.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.model.User;
import com.mrk.dao.UserDao;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private UserDao userDao = new UserDao();
	private JTextField userNameText;
	private JTextField phoneText;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JRadioButton radioButtonMan;
	private JRadioButton radioButtonWoman;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setTitle("\u7528\u6237\u6CE8\u518C\u7A97\u53E3");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u6CE8\u518C");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 22));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("\u624B\u673A\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("\u6027  \u522B");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

		this.radioButtonMan = new JRadioButton("\u7537");
		radioButtonMan.setSelected(true);
		radioButtonMan.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButtonMan.setToolTipText("");

		this.radioButtonWoman = new JRadioButton("\u5973");
		radioButtonWoman.setToolTipText("");
		radioButtonWoman.setFont(new Font("宋体", Font.PLAIN, 20));

		ButtonGroup group = new ButtonGroup();
		group.add(radioButtonMan);
		group.add(radioButtonWoman);

		userNameText = new JTextField();
		userNameText.setFont(new Font("宋体", Font.PLAIN, 20));
		userNameText.setColumns(10);

		phoneText = new JTextField();
		phoneText.setFont(new Font("宋体", Font.PLAIN, 20));
		phoneText.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u5BC6\u7801\u786E\u8BA4");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));

		passwordField1 = new JPasswordField();
		passwordField1.setFont(new Font("宋体", Font.PLAIN, 20));

		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u767B\u5F55\u9875\u9762");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnLogOnActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(207)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3).addComponent(lblNewLabel_5, Alignment.TRAILING))
								.addComponent(lblNewLabel_4))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblNewLabel, Alignment.LEADING)
														.addComponent(userNameText, Alignment.LEADING, 196, 196,
																Short.MAX_VALUE)
														.addComponent(phoneText, Alignment.LEADING)
														.addComponent(passwordField2, Alignment.LEADING, 196, 196,
																Short.MAX_VALUE)
														.addComponent(passwordField1, Alignment.LEADING)
														.addComponent(btnNewButton_1))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(26)
												.addComponent(radioButtonMan)
												.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
												.addComponent(radioButtonWoman).addGap(25)))
								.addGap(211)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(33).addComponent(lblNewLabel).addGap(46)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_1).addComponent(userNameText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(phoneText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
						.addComponent(radioButtonWoman).addComponent(radioButtonMan))
				.addGap(31).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap(80, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);
	}

	/*
	 * 注册用户
	 */
	private void registerActionPerformed(ActionEvent e) {
		// 获取检验数据
		String userName = this.userNameText.getText();
		String phone = this.phoneText.getText();
		String password1 = new String(this.passwordField1.getPassword());
		String password2 = new String(this.passwordField2.getPassword());
		String sex = "男";
		if (this.radioButtonWoman.isSelected()) {
			sex = "女";
		}
		// 校验数据
		if (ToolUtils.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		} else if (ToolUtils.isEmpty(password1)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		} else if (ToolUtils.isEmpty(password2)) {
			JOptionPane.showMessageDialog(null, "请再次输入密码！");
			return;
		} else if (!ToolUtils.isSame(password1, password2)) {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
			return;
		} else if (ToolUtils.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "手机号不能为空！");
			return;
		} else if(!ToolUtils.isPhoneNumber(phone)) {
			JOptionPane.showMessageDialog(null, "手机号格式不正确！");
			return;
		}
		// 封装数据
		User InsertUser = new User(userName, password1, StatusOrTypeConstants.ORDINARY_USER, sex, phone);
		// 提交数据
		Connection con = DBUtils.getConnection();
		Boolean reusult = userDao.inserUser(con, InsertUser);

		// 判断是否注册成功
		if (reusult) {
			JOptionPane.showMessageDialog(null, "注册成功！");
		} else {
			JOptionPane.showMessageDialog(null, "注册失败 请联系管理员！");
			return;
		}
	}

	/*
	 * 返回登录界面
	 */
	private void returnLogOnActionPerformed(ActionEvent e) {
		dispose();
		new LogOnFrame().setVisible(true);
	}
}
