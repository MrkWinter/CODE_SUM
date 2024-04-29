package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.model.Book;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class BookInfoAddFrame extends JFrame {

	//��ҳ��
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	// Dao
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	// ��ȡ��Ϣ���
	private JTextField bookNameText;
	private JTextField authorText;
	private JTextField publisherText;
	private JTextField priceText;
	private JTextField numberText;
	private JComboBox typeComboBox;
	private JTextArea remarkTArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfoAddFrame frame = new BookInfoAddFrame();
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
	public BookInfoAddFrame(RootMainFrame rootMainFrame) {
		//��ʼ����ҳ�����
		this.rootMainFrame = rootMainFrame;
		
		setTitle("\u56FE\u4E66\u6DFB\u52A0\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u6DFB\u52A0");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("\u51FA\u7248\u793E");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("\u4EF7\u683C");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("\u5E93\u5B58");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_6 = new JLabel("\u7C7B\u522B");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 20));

		bookNameText = new JTextField();
		bookNameText.setFont(new Font("����", Font.PLAIN, 20));
		bookNameText.setColumns(10);

		authorText = new JTextField();
		authorText.setFont(new Font("����", Font.PLAIN, 20));
		authorText.setColumns(10);

		publisherText = new JTextField();
		publisherText.setFont(new Font("����", Font.PLAIN, 20));
		publisherText.setColumns(10);

		priceText = new JTextField();
		priceText.setFont(new Font("����", Font.PLAIN, 20));
		priceText.setColumns(10);

		numberText = new JTextField();
		numberText.setFont(new Font("����", Font.PLAIN, 20));
		numberText.setColumns(10);

		remarkTArea = new JTextArea();
		remarkTArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		remarkTArea.setForeground(new Color(0, 0, 0));

		typeComboBox = new JComboBox();
		typeComboBox.setFont(new Font("����", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ���ͼ���¼�
				addBookActionPerformed(arg0);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//������Ϣ
				resetBookAddInfoActionPerformed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(283).addComponent(lblNewLabel)
						.addContainerGap(305, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(62)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_5).addComponent(lblNewLabel_7))
						.addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(144)
										.addComponent(btnNewButton_1).addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(publisherText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(remarkTArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														381, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING)
														.addComponent(numberText, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED, 90,
																Short.MAX_VALUE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNewLabel_4).addComponent(lblNewLabel_6)
																.addComponent(lblNewLabel_2))
														.addGap(31)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(authorText, GroupLayout.DEFAULT_SIZE, 114,
																		Short.MAX_VALUE)
																.addComponent(priceText).addComponent(typeComboBox, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addGap(110)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(81).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2).addComponent(authorText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(30)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(publisherText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4).addComponent(priceText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(numberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6).addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_7)
						.addComponent(remarkTArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(32).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		// �����ı���߿�
		remarkTArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));

		this.setLocationRelativeTo(null);// ���ھ���

		fillTypeComboBox();// ��ʼ������������
	}

	/*
	 * �������ͼ�����Ϣ
	 */
	private void resetBookAddInfoActionPerformed(ActionEvent arg0) {
		resetAddBookInfo();
	}

	/*
	 * ���ͼ���¼�
	 */
	private void addBookActionPerformed(ActionEvent arg0) {
		// 1. ��ȡ��������
		String bookName = bookNameText.getText();
		String author = authorText.getText();
		String publish = publisherText.getText();
		String price = priceText.getText();
		String number = numberText.getText();
		// ��Ϊ�������ʼ��ʱ����ľ���BookType���� ��������ֱ��ǿת
		BookType bookType = (BookType) typeComboBox.getSelectedItem();
		String remark = remarkTArea.getText();
		// У������
		if (ToolUtils.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(publish)) {
			JOptionPane.showMessageDialog(null, "��������Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "�۸���Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(number)) {
			JOptionPane.showMessageDialog(null, "�����Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(bookType)) {
			JOptionPane.showMessageDialog(null, "�����Ϣ����Ϊ�գ�");
			return;
		} else if (ToolUtils.isEmpty(remark)) {
			JOptionPane.showMessageDialog(null, "ͼ��������Ϣ����Ϊ�գ�");
			return;
		} else if (!ToolUtils.isPositiveNumber(price)) {
			JOptionPane.showMessageDialog(null, "�۸���Ϣ��ʽ����");
			return;
		} else if (!ToolUtils.isPositiveInteger(number)) {
			JOptionPane.showMessageDialog(null, "�����Ϣ��ʽ����");
			return;
		}
		Double priceDou = Double.parseDouble(price);
		Integer numberInt = Integer.parseInt(number);
		//��װ����
		Book insertBook = new Book(bookName,bookType.getId(),author,publish,priceDou,numberInt,StatusOrTypeConstants.ON_BORROW,remark);
		// 2. ���Բ������� Ĭ��״̬����Ϊ���ɽ���
		Connection con = DBUtils.getConnection();
		Boolean result = bookDao.add(con, insertBook);
		if(result) {
			//�ɹ�
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
			
			resetAddBookInfo();
			// 3.����ɹ�������ѡ����Ϣ���� -- ��װ����
			resetAddBookInfo();
			// 4.ˢ����ҳ��չʾͼ�����Ϣ
			rootMainFrame.fillBookInfoTable(null,null,null);
		} else {
			JOptionPane.showMessageDialog(null, "���ʧ�� ϵͳ����");
			return;
		}
	}

	//�����ı���Ϣ
	private void resetAddBookInfo() {
		bookNameText.setText("");
		authorText.setText("");
		publisherText.setText("");
		priceText.setText("");
		numberText.setText("");
		if (typeComboBox.getItemCount() > 0) {
			typeComboBox.setSelectedIndex(0); // �����ѡ���һ��ѡ��
		}
		remarkTArea.setText("");
	}

	/*
	 * ��ʼ��ͼ���������������
	 */
	private void fillTypeComboBox() {
		try {
			Connection con = DBUtils.getConnection();
			// ���︴��list���� ���������Ϊ���򷵻�����������ݵ�result����
			ResultSet rs = bookTypeDao.listByTypeName(con, null);
			BookType bookType = null;
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setTypeName(rs.getString("type_name"));
				// ����������������Ӷ��� Ŀ�����ڻ�ȡ����ʱ����ֱ�ӻ�ȡ��Ӧ����id ����ͼ��������
				// ������չʾ��������ʱ�����toString���� �����Ѿ���д�÷��� ��չʾ��Ϊ�����Ϣ
				this.typeComboBox.addItem(bookType);
			}
			DBUtils.close(rs, null, con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
