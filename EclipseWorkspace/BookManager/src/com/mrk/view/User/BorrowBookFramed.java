package com.mrk.view.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mrk.constants.StatusOrTypeConstants;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BorrowBookFramed extends JFrame {

	private User logUser = null;
	private JPanel contentPane;
	private BookDao bookDao = new BookDao();
	private BorrowDetailsDao borrowDetailsDao = new BorrowDetailsDao();
	private JTextField borrowBookIdText;
	private JTextField borrowBookNameText;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BorrowBookFramed frame = new BorrowBookFramed();
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
	public BorrowBookFramed(User logUser) {
		setTitle("\u501F\u4E66\u64CD\u4F5C");



		this.logUser = logUser;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u501F\u4E66\u754C\u9762");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		borrowBookIdText = new JTextField();
		borrowBookIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		borrowBookIdText.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u5B9A\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrowBookActionPerformed(arg0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u4E66\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		borrowBookNameText = new JTextField();
		borrowBookNameText.setFont(new Font("宋体", Font.PLAIN, 20));
		borrowBookNameText.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(borrowBookIdText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(borrowBookNameText, GroupLayout.PREFERRED_SIZE, 115,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
								.addComponent(btnNewButton).addGap(29)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(31).addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(borrowBookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2).addComponent(borrowBookNameText, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
				.addGap(74)));
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);
	}

    //执行借书操作
	private void borrowBookActionPerformed(ActionEvent arg0) {
		// 1. 获取借书数据 进行检验
		// 2.数据库中查询book表是否有对应的书籍可借用
		// 3.向数据库borrow_detail中添加数据
		String borrowBookID = borrowBookIdText.getText();
		String borrowBookName = borrowBookNameText.getText();
		if (ToolUtils.isEmpty(borrowBookID)) {
			JOptionPane.showMessageDialog(null, "书籍编号不能为空！");
			return;
		} else if (ToolUtils.isEmpty(borrowBookName)) {
			JOptionPane.showMessageDialog(null, "书名不能为空！");
			return;
		} else if(!ToolUtils.isPositiveInteger(borrowBookID)) {
			JOptionPane.showMessageDialog(null, "书籍编号格式有误！");
			return;
		}
		Integer borrowBookId = Integer.parseInt(borrowBookID);
		

		//同一本书一个用户只能借阅一本
		Connection con1 = DBUtils.getConnection();
		BorrowDetails bd = 	new BorrowDetails();
		bd.setUserId(logUser.getId());
		bd.setBookId(borrowBookId);
		if(borrowDetailsDao.isBorrowed(con1, bd)) {
			JOptionPane.showMessageDialog(null, "您已借阅过该图书，请归还后再次借阅！");
			return;
		}
		//查询借阅数据 如果该用户有借此书并且没有归还 则不能借阅
		Connection con = DBUtils.getConnection();
		if (bookDao.IsBorrowBook(con, borrowBookId, borrowBookName)) {
			// 可以进行借书 封装数据
			con = DBUtils.getConnection();
			BorrowDetails insertBorrowDetails = new BorrowDetails();
			insertBorrowDetails.setUserId(logUser.getId());
			insertBorrowDetails.setBookId(borrowBookId);
			insertBorrowDetails.setStatus(StatusOrTypeConstants.NOT_RETURN);
			insertBorrowDetails.setBorrowTime(ToolUtils.getCurrentTime());

			if (borrowDetailsDao.insert(con, insertBorrowDetails)) {
				JOptionPane.showMessageDialog(null, "借书成功,请记得及时归还！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "借书失败,请检查可借阅书籍信息！");
		}
	}
}
