package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.UserDao;
import com.mrk.model.BookType;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;

public class UserInfoUpdateFrame extends JFrame {
	// ��ҳ��
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	// Dao
	private UserDao userDao = new UserDao();
	// �������
	private JTextField userInfoText;
	private JTable userInfoTable;
	// �޸���Ϣ���
	private JTextField userIdText;
	private JTextField usernameText;
	private JTextField passwordText;
	private JComboBox roleComboBox;
	private JRadioButton manRadioButton;
	private JRadioButton womanRadioButton;
	private JTextField phoneText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserInfoUpdateFrame frame = new UserInfoUpdateFrame();
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
	public UserInfoUpdateFrame(RootMainFrame rootMainFrame) {
		// ��ʼ����ҳ�����
		this.rootMainFrame = rootMainFrame;

		setTitle("\u7528\u6237\u4FE1\u606F\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7528\u6237\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7528\u6237\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 738,
										Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 738,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));

		userIdText = new JTextField();
		userIdText.setEditable(false);
		userIdText.setFont(new Font("����", Font.PLAIN, 20));
		userIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));

		usernameText = new JTextField();
		usernameText.setFont(new Font("����", Font.PLAIN, 20));
		usernameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));

		passwordText = new JTextField();
		passwordText.setFont(new Font("����", Font.PLAIN, 20));
		passwordText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u7C7B\u578B");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 20));

		roleComboBox = new JComboBox();
		roleComboBox.setFont(new Font("����", Font.PLAIN, 20));
		roleComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "\u666E\u901A\u7528\u6237", "\u7BA1\u7406\u5458" }));

		JLabel lblNewLabel_5 = new JLabel("\u6027\u522B");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 20));

		manRadioButton = new JRadioButton("\u7537");
		buttonGroup.add(manRadioButton);
		manRadioButton.setSelected(true);
		manRadioButton.setFont(new Font("����", Font.PLAIN, 20));

		womanRadioButton = new JRadioButton("\u5973");
		buttonGroup.add(womanRadioButton);
		womanRadioButton.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_6 = new JLabel("\u7535\u8BDD");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 20));

		phoneText = new JTextField();
		phoneText.setFont(new Font("����", Font.PLAIN, 20));
		phoneText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �û���Ϣ�޸��¼�
				userInfoUpdateActionPerformed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));

		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �����ı���Ϣ�¼�
				resetUpdateTypeInfoActionPerformed(arg0);
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
												.addComponent(roleComboBox, Alignment.TRAILING, 0,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(userIdText, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
										.addGap(37)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2).addComponent(lblNewLabel_5)))
								.addComponent(btnNewButton_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
								.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(manRadioButton)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(womanRadioButton))
										.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 136,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_3)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(passwordText,
														GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_6)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(phoneText,
														GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
								.addComponent(btnNewButton_2))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(userIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2).addComponent(lblNewLabel_3).addComponent(passwordText,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(roleComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5).addComponent(manRadioButton).addComponent(womanRadioButton)
								.addComponent(lblNewLabel_6).addComponent(phoneText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(28).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1).addComponent(btnNewButton_2))
						.addContainerGap(260, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));

		userInfoText = new JTextField();
		userInfoText.setFont(new Font("����", Font.PLAIN, 20));
		userInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �û��޸Ĵ��� �û���Ϣ�����¼�
				searchUserInfoActionPerfromed(arg0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(126).addComponent(lblNewLabel).addGap(45)
								.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addGap(65).addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE).addContainerGap()));

		userInfoTable = new JTable();
		userInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// ���������¼� �ӱ�����л�ȡ����
				userInfoTablePressedToGetInfo(arg0);
			}
		});
		userInfoTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
				"\u7528\u6237\u7C7B\u578B", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6027\u522B", "\u7535\u8BDD" }));
		userInfoTable.setFont(new Font("����", Font.PLAIN, 19));
		scrollPane.setViewportView(userInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// ���ھ���
		// ����û������Ϣ����
		fillUserInfoTable(null);
	}

	// �û���Ϣ�޸��¼�
	private void userInfoUpdateActionPerformed(ActionEvent arg0) {
		// 1. ��ȡ����
		String userId = userIdText.getText();
		String username = usernameText.getText();
		String password = passwordText.getText();
		String role = (String) roleComboBox.getSelectedItem();
		String sex = "��";
		if (womanRadioButton.isSelected()) {
			sex = "Ů";
		}
		String phone = phoneText.getText();
		// 2. У������
		if (ToolUtils.isEmpty(userId)) {
			JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "�ֻ��Ų���Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(sex)) { // ��׳��
			JOptionPane.showMessageDialog(null, "�Ա���Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(role)) {
			JOptionPane.showMessageDialog(null, "�û����Ͳ���Ϊ�գ�");
			return;
		} else if (!ToolUtils.isPhoneNumber(phone)) {
			JOptionPane.showMessageDialog(null, "�绰��ʽ���� ��");
			return;
		}
		Integer userIdInt = Integer.parseInt(userId);
		Integer roleInt = StatusOrTypeConstants.ORDINARY_USER;
		if (ToolUtils.isSame(role, StatusOrTypeConstants.ROOT_STR)) {
			roleInt = StatusOrTypeConstants.ROOT;
		}
		// 3. ��֤�Ƿ���Ը���
		if (ToolUtils.isSame(roleInt, StatusOrTypeConstants.ORDINARY_USER)) {
			Connection con = DBUtils.getConnection();
			Boolean isOnlyRoot = userDao.isOnlyRoot(con, userIdInt);
			if (isOnlyRoot) {
				JOptionPane.showMessageDialog(null, "���û�ΪΨһ����Ա��ϵͳ���������Ϊ��ͨ�û� ��");
				return;
			}
		}
		// 4. ִ�в���
		User updateUser = new User(username, password, roleInt, sex, phone);
		updateUser.setId(userIdInt);
		Connection con = DBUtils.getConnection();
		Boolean isUpdate = userDao.updateById(con, updateUser);
		if (isUpdate) {
			JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			// 5. �����ı���Ϣ
			resetUpdateTypeInfo();
			// 6. ˢ���û��޸�ҳ���û���Ϣ����
			fillUserInfoTable(null);
			// 7. ˢ����ҳ���û���Ϣ����
			rootMainFrame.fillUserInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "�޸�ʧ�� ϵͳ���� ��");
			return;
		}

	}

	// �û��޸�ҳ�� �����ı���Ϣ�¼�
	private void resetUpdateTypeInfoActionPerformed(ActionEvent arg0) {
		resetUpdateTypeInfo();
	}

	/*
	 * ����е���¼�����
	 */
	private void userInfoTablePressedToGetInfo(MouseEvent arg0) {

		Integer row = userInfoTable.getSelectedRow();
		// �޸���Ϣ���
		userIdText.setText((String) userInfoTable.getValueAt(row, 0));
		usernameText.setText((String) userInfoTable.getValueAt(row, 2));
		passwordText.setText((String) userInfoTable.getValueAt(row, 3));
		// ������ѡ�� ��Ϊ�ӱ���л�ȡ�ĺ��������еĶ����ַ��� ���ݱȶԿ���ֱ��ѡ��
		roleComboBox.setSelectedItem((String) userInfoTable.getValueAt(row, 1));
		String sex = (String) userInfoTable.getValueAt(row, 4);
		if (ToolUtils.isSame(sex, "Ů")) {
			manRadioButton.setSelected(false);
			womanRadioButton.setSelected(true);
		} else {
			womanRadioButton.setSelected(false);
			manRadioButton.setSelected(true);
		}
		phoneText.setText((String) userInfoTable.getValueAt(row, 5));
	}

	/**
	 * �����޸��û���Ϣ���� �ı���Ϣ����
	 */
	private void resetUpdateTypeInfo() {
		userIdText.setText("");
		usernameText.setText("");
		passwordText.setText("");
		roleComboBox.setSelectedIndex(0);
		womanRadioButton.setSelected(false);
		manRadioButton.setSelected(true);
		phoneText.setText("");
	}

	// �û��޸Ĵ��� �û���Ϣ�����¼�
	private void searchUserInfoActionPerfromed(ActionEvent e) {

		// ��ȡ����
		String searchStr = userInfoText.getText();

		if (ToolUtils.isNotEmpty(searchStr)) {
			fillUserInfoTable(searchStr);
		} else {
			// Ϊ��ˢ��
			fillUserInfoTable(null);
		}
	}

	// ����û������Ϣ����
	public void fillUserInfoTable(String userName) {
		DefaultTableModel dtm = (DefaultTableModel) userInfoTable.getModel();
		dtm.setRowCount(0);// ���
		try {
			Connection con = DBUtils.getConnection();
			// ���Dao�����������ݽ����
			ResultSet rs = userDao.listByUserName(con, userName);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("role"));
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("phone"));
				dtm.addRow(v);// ���һ�� ��˳��չʾ
			}
			DBUtils.close(rs, null, con); // ���� bookDao.list ����Ҫ��ȡ������ δ����
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
