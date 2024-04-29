package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mrk.constants.StatusOrTypeConstants;
import com.mrk.dao.BookDao;
import com.mrk.dao.BookTypeDao;
import com.mrk.model.Book;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookInfoUpdateFrame extends JFrame {
	// ��ҳ��
	private RootMainFrame rootMainFrame;
	private JPanel contentPane;
	// Dao
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	// ������Ϣ���
	private JTextField searchText;
	private JComboBox searchComboBox;
	private JTable bookInfoTable;
	// �޸���Ϣ���
	private JTextField bookIdText;
	private JTextField bookNameText;
	private JTextField authorText;
	private JComboBox bookTypeComboBox;
	private JTextField publishText;
	private JTextField priceText;
	private JTextField numberText;
	private JComboBox statusComboBox;
	private JTextArea remarkTArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInfoUpdateFrame frame = new BookInfoUpdateFrame();
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
	public BookInfoUpdateFrame(RootMainFrame rootMainFrame) {
		// ��ʼ����ҳ�����
		this.rootMainFrame = rootMainFrame;

		setTitle("\u56FE\u4E66\u4FEE\u6539\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 939, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(37)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7  ");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));

		bookIdText = new JTextField();
		bookIdText.setEditable(false);
		bookIdText.setFont(new Font("����", Font.PLAIN, 20));
		bookIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u4E66\u540D");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));

		bookNameText = new JTextField();
		bookNameText.setFont(new Font("����", Font.PLAIN, 20));
		bookNameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));

		authorText = new JTextField();
		authorText.setFont(new Font("����", Font.PLAIN, 20));
		authorText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u7C7B\u522B");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 20));

		bookTypeComboBox = new JComboBox();
		bookTypeComboBox.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("\u51FA\u7248\u793E");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 20));

		publishText = new JTextField();
		publishText.setFont(new Font("����", Font.PLAIN, 20));
		publishText.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 20));

		priceText = new JTextField();
		priceText.setFont(new Font("����", Font.PLAIN, 20));
		priceText.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("\u5E93\u5B58");
		lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 20));

		numberText = new JTextField();
		numberText.setFont(new Font("����", Font.PLAIN, 20));
		numberText.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("\u72B6\u6001");
		lblNewLabel_8.setFont(new Font("����", Font.PLAIN, 20));

		statusComboBox = new JComboBox();
		statusComboBox.setFont(new Font("����", Font.PLAIN, 20));
		statusComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "\u53EF\u501F\u9605", "\u4E0D\u53EF\u501F\u9605" }));

		JLabel lblNewLabel_9 = new JLabel("\u63CF\u8FF0");
		lblNewLabel_9.setFont(new Font("����", Font.PLAIN, 20));

		remarkTArea = new JTextArea();
		remarkTArea.setFont(new Font("Monospaced", Font.PLAIN, 18));

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �޸���Ϣ�¼�
				bookInfoUpdateActionPerformed(arg0);
			}
		});

		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���������ı���Ϣ�¼�
				resetUpdateBookInfoActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_9).addComponent(lblNewLabel_1))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addComponent(publishText)
								.addComponent(bookIdText, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(bookNameText, Alignment.LEADING).addComponent(priceText,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
						.addComponent(remarkTArea, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
				.addGap(30)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3).addComponent(lblNewLabel_7))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(numberText, 168, 168, Short.MAX_VALUE).addComponent(btnNewButton_1)
						.addComponent(authorText))
				.addGap(33)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_8))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(statusComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(bookTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(btnNewButton_2))
				.addGap(69)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(
						30)
				.addGroup(
						gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
								.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4).addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(publishText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(numberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8).addComponent(statusComboBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_9)
						.addComponent(remarkTArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2).addComponent(btnNewButton_1))
				.addContainerGap(326, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("\u641C\u7D22\u6761\u4EF6");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));

		searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] { "\u4E66\u7C4D\u540D\u79F0",
				"\u4E66\u7C4D\u7C7B\u522B", "\u72B6\u6001(\u53EF\u501F\u9605/\u4E0D\u53EF\u501F\u9605)" }));
		searchComboBox.setFont(new Font("����", Font.PLAIN, 20));

		searchText = new JTextField();
		searchText.setFont(new Font("����", Font.PLAIN, 20));
		searchText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯͼ����Ϣ�¼�
				searchBookInfoActionPerfromed(e);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(116).addComponent(lblNewLabel)
										.addGap(48)
										.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(48)
										.addComponent(searchText, GroupLayout.PREFERRED_SIZE, 155,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(btnNewButton))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)
										.addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addContainerGap()));

		bookInfoTable = new JTable();
		bookInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// �������������¼� �ɴ��¼�������е�ĳһ�����ݼ��뵽��Ҫ�޸�ͼ��������ı���Ϣ��ȥ �򻯲���
				bookInfoTablePressedToGetInfo(arg0);
			}
		});
		bookInfoTable.setFont(new Font("����", Font.PLAIN, 19));
		bookInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u4E66\u540D", "\u7C7B\u522B", "\u4F5C\u8005", "\u51FA\u7248\u793E",
						"\u4EF7\u683C", "\u5E93\u5B58", "\u72B6\u6001", "\u63CF\u8FF0" }));
		scrollPane.setViewportView(bookInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// ���ھ���

		// �����ı���߿�
		remarkTArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
		// ��ʼ���޸�ͼ������Ϣ
		fillBookInfoTable(null, null, null);
		// ��ʼ���޸���Ϣ���������
		fillTypeComboBox();

	}

	// �޸���Ϣ�¼�
	private void bookInfoUpdateActionPerformed(ActionEvent arg0) {
		// 1. ��ȡ��Ϣ
		String bookId = bookIdText.getText();
		String bookName = bookNameText.getText();
		String author = authorText.getText();
		// ������ - ����
		BookType bookType = (BookType) bookTypeComboBox.getSelectedItem();

		String publish = publishText.getText();
		String price = priceText.getText();
		String number = numberText.getText();
		// ������ - ״̬
		String status = (String) statusComboBox.getSelectedItem();
		Integer statusInt = null;
		if (ToolUtils.isSame(status, StatusOrTypeConstants.NOT_BORROW_STR)) {
			// �ɽ���
			statusInt = 0;
		} else {
			// ���ɽ���
			statusInt = 1;
		}

		String remark = remarkTArea.getText();
		// 2. У������
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
		Integer bookIdInt = Integer.parseInt(bookId);
		Double priceDou = Double.parseDouble(price);
		Integer numberInt = Integer.parseInt(number);
		// 3. ��װ��Ϣ
		Book updateBook = new Book(bookName, bookType.getId(), author, publish, priceDou, numberInt, statusInt, remark);
		updateBook.setId(bookIdInt);

		// 4. ִ�в���
		Connection con = DBUtils.getConnection();
		Boolean result = bookDao.updateById(con, updateBook);
		if (result) {
			JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			// 5. ��������ı���Ϣ
			resetUpdateBookInfo();
			// 6. ˢ�µ�ǰҳ��ͼ��������Ϣ
			fillBookInfoTable(null, null, null);
			// 7. ˢ����ҳ��ͼ��������Ϣ
			this.rootMainFrame.fillBookInfoTable(null, null, null);
		} else {
			JOptionPane.showMessageDialog(null, "�޸�ʧ�� ϵͳ����");
			return;
		}

	}

	/*
	 * ��ʼ���޸���Ϣ���������
	 */

	// ���������ı���Ϣ�¼�
	private void resetUpdateBookInfoActionPerformed(ActionEvent e) {
		resetUpdateBookInfo();
	}

	// ���������ı���Ϣ
	private void resetUpdateBookInfo() {

		bookIdText.setText("");
		bookNameText.setText("");
		authorText.setText("");
		if (bookTypeComboBox.getSelectedIndex() != -1) { // ��ѡ�ѡ��
			bookTypeComboBox.setSelectedIndex(0);
		}
		publishText.setText("");
		priceText.setText("");
		numberText.setText("");
		if (statusComboBox.getSelectedIndex() != -1) { // ��ѡ�ѡ��
			statusComboBox.setSelectedIndex(0);
		}
		remarkTArea.setText("");
	}

	// �������ѡ��
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
				this.bookTypeComboBox.addItem(bookType);
			}
			DBUtils.close(rs, null, con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * ����е���¼�����
	 */
	private void bookInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = bookInfoTable.getSelectedRow();
		// �޸���Ϣ���
		bookIdText.setText((String) bookInfoTable.getValueAt(row, 0));
		bookNameText.setText((String) bookInfoTable.getValueAt(row, 1));
		authorText.setText((String) bookInfoTable.getValueAt(row, 3));
		// ������ ���� �Խ���Ҫ��дequals����
		String bookTypeStr = (String) bookInfoTable.getValueAt(row, 2);
		BookType bookType = new BookType(bookTypeStr, null);
		bookTypeComboBox.setSelectedItem(bookType);

		publishText.setText((String) bookInfoTable.getValueAt(row, 4));
		priceText.setText((String) bookInfoTable.getValueAt(row, 5));
		numberText.setText((String) bookInfoTable.getValueAt(row, 6));
		// ״̬������
		String status = (String) bookInfoTable.getValueAt(row, 7);
		statusComboBox.setSelectedItem(status);

		remarkTArea.setText((String) bookInfoTable.getValueAt(row, 8));
	}

	// ͼ����Ϣ�����¼�
	private void searchBookInfoActionPerfromed(ActionEvent arg0) {
		// ��ȡ����
		String searchStr = searchText.getText();
		String condition = (String) searchComboBox.getSelectedItem();
		if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_NAME)) {
			// ����������
			fillBookInfoTable(searchStr, null, null);
		} else if (ToolUtils.isSame(condition, StatusOrTypeConstants.SEARCH_BY_TYPE)) {
			// ���������
			fillBookInfoTable(null, searchStr, null);
		} else {
			// ���һ����� ����������ѯ �˷�֧�мǵ�ˢ��
			if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.NOT_BORROW_STR)) {
				// �ɽ���
				fillBookInfoTable(null, null, StatusOrTypeConstants.NOT_BORROW);
			} else if (ToolUtils.isSame(searchStr, StatusOrTypeConstants.ON_BORROW_STR)) {
				// ���ɽ���
				fillBookInfoTable(null, null, StatusOrTypeConstants.ON_BORROW);
			} else {
				// ˢ��
				fillBookInfoTable(null, null, null);
			}

		}

	}

	// ��������޸�ͼ������Ϣ
	public void fillBookInfoTable(String bookName, String typeName, Integer status) {
		DefaultTableModel dtm = (DefaultTableModel) bookInfoTable.getModel();
		dtm.setRowCount(0);// ���
		try {
			Connection con = DBUtils.getConnection();
			ResultSet rs = bookDao.listUpdateInfo(con, bookName, typeName, status);
			while (rs.next()) {
				Vector v = new Vector();
				// ����ȫ��ת����String ���ں������
				v.add(rs.getString("book.id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("author"));
				v.add(rs.getString("publish"));
				v.add(rs.getString("price"));
				v.add(rs.getString("number"));
				v.add(rs.getString("status"));
				v.add(rs.getString("book.remark"));
				dtm.addRow(v);// ���һ�� ��˳��չʾ
			}
			DBUtils.close(rs, null, con); // ���� bookDao.list ����Ҫ��ȡ������ δ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
