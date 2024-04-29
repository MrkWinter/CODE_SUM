package com.mrk.view.root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mrk.dao.BookTypeDao;
import com.mrk.model.BookType;
import com.mrk.utils.DBUtils;
import com.mrk.utils.ToolUtils;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class TypeInfoUpdateFrame extends JFrame {
	// 主页面
	private RootMainFrame rootMainFrame;
	// Dao
	private BookTypeDao bookTypeDao = new BookTypeDao();
	//
	private JPanel contentPane;
	// 搜索信息组件
	private JTextField typeInfoText;
	private JTable typeInfoTable;
	// 修改信息组件
	private JTextField typeIdText;
	private JTextField typeNametText;
	private JTextArea remarkTArea;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TypeInfoUpdateFrame frame = new TypeInfoUpdateFrame();
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
	public TypeInfoUpdateFrame(RootMainFrame rootMainFrame) {
		// 初始化主页面对象
		this.rootMainFrame = rootMainFrame;

		setTitle("\u7C7B\u522B\u4FEE\u6539\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7C7B\u522B\u4FE1\u606F\u603B\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7C7B\u522B\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 648,
										Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 648,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		typeIdText = new JTextField();
		typeIdText.setEditable(false);
		typeIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		typeNametText = new JTextField();
		typeNametText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeNametText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 修改类别信息事件
				typeInfoUpdateActionPerformed(arg0);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 信息重置事件
				resetUpdateTypeInfoActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("\u7C7B\u522B\u63CF\u8FF0");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

		remarkTArea = new JTextArea();
		remarkTArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addGap(23)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_3))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addComponent(remarkTArea)
								.addComponent(typeIdText, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_1)
								.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(typeNametText, GroupLayout.PREFERRED_SIZE, 209,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(64).addComponent(btnNewButton_2)))
						.addGap(15)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(typeNametText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(typeIdText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(33)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2).addComponent(lblNewLabel_3).addComponent(remarkTArea,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		typeInfoText = new JTextField();
		typeInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 修改页面 类别搜索
				searchTypeInfoActionPerfromed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(77).addComponent(lblNewLabel).addGap(29)
								.addComponent(typeInfoText, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGap(40).addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(typeInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addComponent(lblNewLabel))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE).addContainerGap()));

		typeInfoTable = new JTable();
		typeInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// 类别表格点击事件
				typeInfoTablePressedToGetInfo(arg0);
			}
		});
		typeInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u63CF\u8FF0" }));
		typeInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		scrollPane.setViewportView(typeInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// 窗口居中

		// 设置文本域边框
		remarkTArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
		// 类别填充
		fillTypeInfoTable(null);
	}

	// 修改页面 修改类别信息事件
	private void typeInfoUpdateActionPerformed(ActionEvent arg0) {
		// 1. 获取数据
		String typeId = typeIdText.getText();
		String typeName = typeNametText.getText();
		String remark = remarkTArea.getText();
		// 2. 数据校验
		if (ToolUtils.isEmpty(typeId)) {
			JOptionPane.showMessageDialog(null, "编号不能为空！");
			return;
		} else if (ToolUtils.isEmpty(typeName)) {
			JOptionPane.showMessageDialog(null, "类别名称不能为空！");
			return;
		} else if (ToolUtils.isEmpty(remark)) {
			JOptionPane.showMessageDialog(null, "类别描述不能为空！");
			return;
		} else if (!ToolUtils.isPositiveInteger(typeId)) {
			JOptionPane.showMessageDialog(null, "编号格式有误！");
			return;
		}
		Integer typeIdInt = Integer.parseInt(typeId);
		// 3. 执行操作
		BookType updateBookType = new BookType(typeName, remark);
		updateBookType.setId(typeIdInt);
		Connection con = DBUtils.getConnection();
		Boolean result = bookTypeDao.updateById(con, updateBookType);
		if (result) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			// 4. 重置文本信息
			resetUpdateTypeInfo();
			// 5. 刷新修改类别页面信息
			fillTypeInfoTable(null);
			// 6.刷新主页面类别信息
			rootMainFrame.fillTypeInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "修改失败 系统错误！");
			return;
		}

	}

	// 信息重置事件
	private void resetUpdateTypeInfoActionPerformed(ActionEvent e) {
		resetUpdateTypeInfo();
	}

	/**
	 * 重置添加类别界面 文本信息方法
	 */
	private void resetUpdateTypeInfo() {
		typeIdText.setText("");
		typeNametText.setText("");
		remarkTArea.setText("");
	}

	/*
	 * 表格行点击事件处理
	 */
	private void typeInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = typeInfoTable.getSelectedRow();
		// 修改信息组件
		typeIdText.setText((String) typeInfoTable.getValueAt(row, 0));
		typeNametText.setText((String) typeInfoTable.getValueAt(row, 1));
		remarkTArea.setText((String) typeInfoTable.getValueAt(row, 2));
	}

	// 类别搜索事件
	private void searchTypeInfoActionPerfromed(ActionEvent arg0) {

		// 获取数据
		String searchStr = typeInfoText.getText();

		if (ToolUtils.isNotEmpty(searchStr)) {
			fillTypeInfoTable(searchStr);
		} else {
			// 为空刷新
			fillTypeInfoTable(null);
		}
	}

	// 类别修改页面 填充类别表格信息方法
	public void fillTypeInfoTable(String typeName) {
		DefaultTableModel dtm = (DefaultTableModel) typeInfoTable.getModel();
		dtm.setRowCount(0);// 清空
		try {
			Connection con = DBUtils.getConnection();
			// 类别Dao方法返回数据结果集
			ResultSet rs = bookTypeDao.listByTypeName(con, typeName);
			while (rs.next()) {
				Vector v = new Vector();
				// 便于表格点击事件获取
				v.add(rs.getString("id"));
				v.add(rs.getString("type_name"));
				v.add(rs.getString("remark"));
				dtm.addRow(v);// 添加一行 按顺序展示
			}
			DBUtils.close(rs, null, con); // 关流 bookDao.list 因需要获取其结果集 未关流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
