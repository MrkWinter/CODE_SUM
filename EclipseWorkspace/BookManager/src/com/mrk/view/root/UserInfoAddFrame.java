package com.mrk.view.root;

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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class UserInfoAddFrame extends JFrame {
	// 主页面
	private RootMainFrame rootMainFrame;
	// Dao
	private UserDao userDao = new UserDao();
	//
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	// 信息组件
	private JTextField usernameText;
	private JTextField passwordText;
	private JTextField phoneText;
	private JRadioButton manRadioButton;
	private JRadioButton womenRadioButton;
	private JComboBox typeComboBox;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserInfoAddFrame frame = new UserInfoAddFrame();
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
	public UserInfoAddFrame(RootMainFrame rootMainFrame) {
		// 初始化主页面对象
		this.rootMainFrame = rootMainFrame;

		setTitle("\u7528\u6237\u4FE1\u606F\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u6DFB\u52A0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		usernameText = new JTextField();
		usernameText.setFont(new Font("宋体", Font.PLAIN, 20));
		usernameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		passwordText = new JTextField();
		passwordText.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u7535\u8BDD");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

		phoneText = new JTextField();
		phoneText.setFont(new Font("宋体", Font.PLAIN, 20));
		phoneText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

		manRadioButton = new JRadioButton("\u7537");
		manRadioButton.setSelected(true);
		manRadioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(manRadioButton);

		womenRadioButton = new JRadioButton("\u5973");
		womenRadioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		buttonGroup.add(womenRadioButton);

		JLabel lblNewLabel_5 = new JLabel("\u7C7B\u578B");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));

		typeComboBox = new JComboBox();
		typeComboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		typeComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "\u666E\u901A\u7528\u6237", "\u7BA1\u7406\u5458" }));

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 添加用户信息事件
				userInfoAddActionPerformed(e);
			}
		});

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 重置输入文本信息
				resetUserInfoAddInfoActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(102)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_4)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_2)
												.addComponent(lblNewLabel_1).addComponent(lblNewLabel_5)
												.addComponent(btnNewButton))
										.addGap(14)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(manRadioButton).addGap(62)
														.addComponent(womenRadioButton))
												.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordText)
												.addComponent(usernameText, GroupLayout.DEFAULT_SIZE, 221,
														Short.MAX_VALUE)
												.addComponent(phoneText)
												.addComponent(btnNewButton_1, Alignment.TRAILING)))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(224).addComponent(lblNewLabel)))
				.addContainerGap(118, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(25).addComponent(lblNewLabel).addGap(28)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(usernameText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(passwordText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(phoneText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
						.addComponent(womenRadioButton).addComponent(manRadioButton))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
				.addGap(31).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
				.addContainerGap(28, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// 窗口居中
	}

	// 添加用户信息事件
	private void userInfoAddActionPerformed(ActionEvent e) {
		// 1.获取信息
		String username = usernameText.getText();
		String password = passwordText.getText();
		String phone = phoneText.getText();
		// 为方便 这里就不用常量代表字符串了
		String sex = "男";
		if (womenRadioButton.isSelected()) {
			sex = "女";
		}
		// 这里固定的为文本选项 所以直接强转
		String role = (String) typeComboBox.getSelectedItem();
		// 2.校验数据
		if (ToolUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		} else if (ToolUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		} else if (ToolUtils.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "手机号不能为空！");
			return;
		} else if (ToolUtils.isEmpty(sex)) { // 健壮性
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return;
		} else if (ToolUtils.isEmpty(role)) {
			JOptionPane.showMessageDialog(null, "用户类型不能为空！");
			return;
		} else if (!ToolUtils.isPhoneNumber(phone)) {
			JOptionPane.showMessageDialog(null, "电话格式有误 ！");
			return;
		}
		Integer roleInt = StatusOrTypeConstants.ORDINARY_USER;
		if (ToolUtils.isSame(role, StatusOrTypeConstants.ROOT_STR)) {
			roleInt = StatusOrTypeConstants.ROOT;
		}

		// 3.执行操作
		User insertUser = new User(username, password, roleInt, sex, phone);
		Connection con = DBUtils.getConnection();
		Boolean isInsert = userDao.insert(con, insertUser);
		if (isInsert) {
			JOptionPane.showMessageDialog(null, "添加成功 ！");
			// 4.重置文本信息
			resetUserInfoAddInfo();
			// 5.刷新主页面用户信息
			rootMainFrame.fillUserInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "添加失败 系统错误！");
			return;
		}

	}

	// 重置添加用户页面 输入文本信息事件
	private void resetUserInfoAddInfoActionPerformed(ActionEvent e) {
		resetUserInfoAddInfo();
	}

	// 重置添加用户界面 文本输入信息
	private void resetUserInfoAddInfo() {
		usernameText.setText("");
		passwordText.setText("");
		phoneText.setText("");
		manRadioButton.setSelected(true);
		womenRadioButton.setSelected(false);
		typeComboBox.setSelectedIndex(0);
	}
}
