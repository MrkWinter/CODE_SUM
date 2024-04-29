package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mrk.dao.BookTypeDao;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TypeInfoAddFrame extends JFrame {
	// ��ҳ��
	private RootMainFrame rootMainFrame;
	// Dao
	private BookTypeDao bookTypeDao = new BookTypeDao();
	//
	private JPanel contentPane;
	// �ı���Ϣ���
	private JTextField bookTypeText;
	private JTextArea remarkTArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TypeInfoAddFrame frame = new TypeInfoAddFrame();
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
	public TypeInfoAddFrame(RootMainFrame rootMainFrame) {
		// ��ʼ����ҳ�����
		this.rootMainFrame = rootMainFrame;

		setTitle("\u7C7B\u522B\u6DFB\u52A0\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u7C7B\u522B\u6DFB\u52A0");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u522B\u63CF\u8FF0");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));

		bookTypeText = new JTextField();
		bookTypeText.setFont(new Font("����", Font.PLAIN, 20));
		bookTypeText.setColumns(10);

		remarkTArea = new JTextArea();
		remarkTArea.setFont(new Font("Monospaced", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �������¼�
				typeInfoInsertActionPerformed(arg0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �������������� �����ı��¼�
				resetInsertTypeInfoActionPerformed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(199).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(31).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_2).addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(
												Alignment.LEADING,
												gl_contentPane.createSequentialGroup().addComponent(btnNewButton)
														.addPreferredGap(ComponentPlacement.RELATED, 101,
																Short.MAX_VALUE)
														.addComponent(btnNewButton_1))
												.addComponent(remarkTArea, GroupLayout.DEFAULT_SIZE, 247,
														Short.MAX_VALUE)
												.addComponent(bookTypeText, GroupLayout.DEFAULT_SIZE, 247,
														Short.MAX_VALUE))))))
				.addGap(117)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(32).addComponent(lblNewLabel).addGap(40)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(bookTypeText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(remarkTArea, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
				.addGap(34).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// ���ھ���

		// �����ı���߿�
		remarkTArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
	}

	// ��������� �������¼�
	private void typeInfoInsertActionPerformed(ActionEvent arg0) {
		// 1. ��ȡ��Ϣ
		String typeName = bookTypeText.getText();
		String remark = remarkTArea.getText();
		// 2. ��ϢУ��
		if (ToolUtils.isEmpty(typeName)) {
			JOptionPane.showMessageDialog(null, "���������Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(remark)) {
			JOptionPane.showMessageDialog(null, "���������Ϣ����Ϊ�գ�");
			return;
		}
		// ��װ����
		BookType insertBookType = new BookType(typeName, remark);
		// 3. ִ�в���
		Connection con = DBUtils.getConnection();
		Boolean result = bookTypeDao.insert(con, insertBookType);
		if(result) {
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
		// 4.�����ı���Ϣ����
			resetInsertTypeInfo();
		// 5.ˢ����ҳ�������Ϣչʾ
			rootMainFrame.fillTypeInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "���ʧ�� ϵͳ����");
			return;
		}

	}

	// ������������� �ı���Ϣ�¼�
	private void resetInsertTypeInfoActionPerformed(ActionEvent arg0) {
		resetInsertTypeInfo();
	}

	/**
	 * ������������� �ı���Ϣ����
	 */
	private void resetInsertTypeInfo() {
		bookTypeText.setText("");
		remarkTArea.setText("");
	}
}
