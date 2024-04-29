package com.mrk.view.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mrk.dao.BookDao;
import com.mrk.dao.BorrowDetailsDao;
import com.mrk.model.BorrowDetails;
import com.mrk.model.User;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ReturnBookFrame extends JFrame {
	private User logUser = null;
	private JPanel contentPane;
	private BookDao bookDao = new BookDao();
	private BorrowDetailsDao borrowDetailsDao = new BorrowDetailsDao();
	private JTextField returnBookIdText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReturnBookFrame frame = new ReturnBookFrame();
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
	public ReturnBookFrame(User logUser) {
		this.logUser = logUser;
		
		
		setTitle("\u8FD8\u4E66\u64CD\u4F5C");
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8FD8\u4E66\u754C\u9762");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u9605\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		
		returnBookIdText = new JTextField();
		returnBookIdText.setFont(new Font("����", Font.PLAIN, 20));
		returnBookIdText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u5F52\u8FD8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				returnBorrowBookActionPerformed(arg0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(27)
							.addComponent(returnBookIdText, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(returnBookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
	}

	//���鴥���¼�
private void returnBorrowBookActionPerformed(ActionEvent arg0) {
	//1. ��ȡ���� �õ�����ı��
	//2. ȥ�������ֱ�Ӹ��Ķ�Ӧ���ı�ź��û���� ���ҽ���״̬Ϊδ�� ������ʾ����
	//3.�����鼮�����Ӧ��������һ �������Ϊ0 ��Ӧ���鼮״̬��Ϊ�ɽ���
	String borrowID = returnBookIdText.getText();
	if(ToolUtils.isEmpty(borrowID)) {
		JOptionPane.showMessageDialog(null, "���ı�Ų���Ϊ�գ�");
		return;
	} else if(!ToolUtils.isPositiveInteger(borrowID)) {
		JOptionPane.showMessageDialog(null, "���ı�Ÿ�ʽ����");
		return;
	}
	Integer borrowId = Integer.parseInt(borrowID);
	Connection con = DBUtils.getConnection();
	BorrowDetails borrowDetails = new BorrowDetails();
	borrowDetails.setId(borrowId);
	borrowDetails.setUserId(logUser.getId());
	if(borrowDetailsDao.update(con, borrowDetails)) {
		Connection con1 = DBUtils.getConnection();
		BorrowDetails bor = borrowDetailsDao.getByid(con1, borrowId);
		Connection con2 = DBUtils.getConnection();
		bookDao.returnBook(con2, bor.getBookId());
		JOptionPane.showMessageDialog(null, "����ɹ���");
	} else {
		JOptionPane.showMessageDialog(null, "����ʧ��,���������Ϣ��");
	}
}

}
