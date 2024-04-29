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

import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class TypeInfoDeleteFrame extends JFrame {
	// ��ҳ��
	private RootMainFrame rootMainFrame;
	// Dao
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	//
	private JPanel contentPane;
	// ������Ϣ���
	private JTextField typeInfoText;
	private JTable typeInfoTable;
	// ������Ϣ���
	private JTextField typeIdText;
	private JTextField typeNametText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TypeInfoDeleteFrame frame = new TypeInfoDeleteFrame();
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
	public TypeInfoDeleteFrame(RootMainFrame rootMainFrame) {
		// ��ʼ����ҳ�����
		this.rootMainFrame = rootMainFrame;

		setTitle("\u7C7B\u522B\u5220\u9664\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7C7B\u522B\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7C7B\u522B\u4FE1\u606F\u5220\u9664", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));

		typeIdText = new JTextField();
		typeIdText.setFont(new Font("����", Font.PLAIN, 20));
		typeIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));

		typeNametText = new JTextField();
		typeNametText.setFont(new Font("����", Font.PLAIN, 20));
		typeNametText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �����Ϣɾ���¼�
				typeInfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(typeIdText, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addGap(28).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(typeNametText, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE).addComponent(btnNewButton_1)
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(typeIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(typeNametText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2).addComponent(btnNewButton_1))
				.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));

		typeInfoText = new JTextField();
		typeInfoText.setFont(new Font("����", Font.PLAIN, 20));
		typeInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �����¼�
				searchTypeInfoActionPerfromed(e);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(73).addComponent(lblNewLabel).addGap(38)
								.addComponent(typeInfoText, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addGap(40).addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(typeInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE).addContainerGap()));

		typeInfoTable = new JTable();
		typeInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// ������¼�
				typeInfoTablePressedToGetInfo(arg0);
			}
		});
		typeInfoTable.setFont(new Font("����", Font.PLAIN, 19));
		typeInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u63CF\u8FF0" }));
		scrollPane.setViewportView(typeInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// ���ھ���
		// �����Ϣ����ʼ��
		fillTypeInfoTable(null);
	}

	/**
	 * �����Ϣɾ���¼�
	 */
	private void typeInfoDeleteActionPerformed(ActionEvent e) {
		// 1. ��ȡ����
		String typeId = typeIdText.getText();
		String typeName = typeNametText.getText();
		// 2. У������
		if (ToolUtils.isEmpty(typeId)) {
			JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(typeName)) {
			JOptionPane.showMessageDialog(null, "������Ʋ���Ϊ�գ�");
			return;
		} else if (!ToolUtils.isPositiveInteger(typeId)) {
			JOptionPane.showMessageDialog(null, "��Ÿ�ʽ����");
			return;
		}
		Integer typeIdInt = Integer.parseInt(typeId);
		// ����ȷ��
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��?(�޷��ָ�)");
		if (result != 0) {
			return;
		}

		// 3. �ж��Ƿ��ɾ��
		Connection con = DBUtils.getConnection();
		Boolean isExiset = bookDao.isExistByTypeId(con, typeIdInt);
		if (isExiset) {
			JOptionPane.showMessageDialog(null, "���������ͼ�飬�봦����ٽ���ɾ����");
			return;
		}
		// 4. ִ�в���
		Connection con1 = DBUtils.getConnection();
		Boolean isDelete = bookTypeDao.deleteByIdAndName(con1, typeIdInt, typeName);
		if (isDelete) {
			JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
			// 5.�����ı�
			resetUpdateTypeInfo();
			// 6. ˢ�����ɾ������ ����ѯ��Ϣ
			fillTypeInfoTable(null);
			// 7. ˢ�������� ����ѯ��Ϣ
			rootMainFrame.fillTypeInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�� ����ɾ����Ϣ��");
			return;
		}

	}

	/**
	 * ������������� �ı���Ϣ����
	 */
	private void resetUpdateTypeInfo() {
		typeIdText.setText("");
		typeNametText.setText("");
	}

	/*
	 * ����е���¼�����
	 */
	private void typeInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = typeInfoTable.getSelectedRow();
		// �޸���Ϣ���
		typeIdText.setText((String) typeInfoTable.getValueAt(row, 0));
		typeNametText.setText((String) typeInfoTable.getValueAt(row, 1));
	}

	// ��������¼�
	private void searchTypeInfoActionPerfromed(ActionEvent arg0) {

		// ��ȡ����
		String searchStr = typeInfoText.getText();

		if (ToolUtils.isNotEmpty(searchStr)) {
			fillTypeInfoTable(searchStr);
		} else {
			// Ϊ��ˢ��
			fillTypeInfoTable(null);
		}
	}

	// ����޸�ҳ�� ����������Ϣ����
	public void fillTypeInfoTable(String typeName) {
		DefaultTableModel dtm = (DefaultTableModel) typeInfoTable.getModel();
		dtm.setRowCount(0);// ���
		try {
			Connection con = DBUtils.getConnection();
			// ���Dao�����������ݽ����
			ResultSet rs = bookTypeDao.listByTypeName(con, typeName);
			while (rs.next()) {
				Vector v = new Vector();
				// ���ڱ�����¼���ȡ
				v.add(rs.getString("id"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("remark"));
				dtm.addRow(v);// ���һ�� ��˳��չʾ
			}
			DBUtils.close(rs, null, con); // ���� bookDao.list ����Ҫ��ȡ������ δ����
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
