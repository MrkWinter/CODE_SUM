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
	// ��ҳ��
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	// Dao
	private UserDao userDao = new UserDao();
	// �������
	private JTextField userInfoText;
	private JTable userInfoTable;
	// ��Ϣ���
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
		// ��ʼ����ҳ�����
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
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));

		userIdText = new JTextField();
		userIdText.setFont(new Font("����", Font.PLAIN, 20));
		userIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));

		usernameText = new JTextField();
		usernameText.setFont(new Font("����", Font.PLAIN, 20));
		usernameText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ɾ���û���Ϣ�¼�
				userInfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));

		userInfoText = new JTextField();
		userInfoText.setFont(new Font("����", Font.PLAIN, 20));
		userInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �û�ɾ������ �û���Ϣ�����¼�
				searchUserInfoActionPerfromed(arg0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));

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
				// ����е���¼�����
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

	// ɾ���û����� ɾ���û���Ϣ�¼�
	private void userInfoDeleteActionPerformed(ActionEvent e) {
		// 1. ��ȡ����
		String userId = userIdText.getText();
		String username = usernameText.getText();
		// 2. У������
		if (ToolUtils.isEmpty(userId)) {
			JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			return;
		} else if (!ToolUtils.isPositiveInteger(userId)) {
			JOptionPane.showMessageDialog(null, "��Ÿ�ʽ����");
			return;
		}
		// ����ȷ��
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��?(�޷��ָ�)");
		if (result != 0) {
			return;
		}

		// 3. ����Ƿ����ɾ��
		Integer userIdInt = Integer.parseInt(userId);
		Connection con = DBUtils.getConnection();
		Boolean isOnlyRoot = userDao.isOnlyRoot(con, userIdInt);
		if (isOnlyRoot) {
			JOptionPane.showMessageDialog(null, "���û�ΪΨһ����Ա��ϵͳ������ɾ�� ��");
			return;
		}
		// 4. ʵʩ����
		Connection con1 = DBUtils.getConnection();
		Boolean isDelete = userDao.deleteByIdAndName(con1, userIdInt, username);
		if (isDelete) {
			JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
			// 5. ������������
			resetDeleteUserInfo();
			// 6. ˢ��ɾ��ҳ���û�����
			fillUserInfoTable(null);
			// 7. ˢ����ҳ���û�����
			rootMainFrame.fillUserInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�� ����ɾ����Ϣ��");
			return;
		}
	}

	/*
	 * ����е���¼�����
	 */
	private void userInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = userInfoTable.getSelectedRow();
		// �޸���Ϣ���
		userIdText.setText((String) userInfoTable.getValueAt(row, 0));
		usernameText.setText((String) userInfoTable.getValueAt(row, 2));
	}

	/**
	 * ����ɾ���û���Ϣ���� �ı���Ϣ����
	 */
	private void resetDeleteUserInfo() {
		userIdText.setText("");
		usernameText.setText("");
	}

	// �û�ɾ������ �û���Ϣ�����¼�
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
