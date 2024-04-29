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
	// 主页面
	private RootMainFrame rootMainFrame;
	// Dao
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	//
	private JPanel contentPane;
	// 搜索信息组件
	private JTextField typeInfoText;
	private JTable typeInfoTable;
	// 输入信息组件
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
		// 初始化主页面对象
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
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		typeIdText = new JTextField();
		typeIdText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeIdText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u522B\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

		typeNametText = new JTextField();
		typeNametText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeNametText.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 类别信息删除事件
				typeInfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
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
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		typeInfoText = new JTextField();
		typeInfoText.setFont(new Font("宋体", Font.PLAIN, 20));
		typeInfoText.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 搜索事件
				searchTypeInfoActionPerfromed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));

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
				// 表格点击事件
				typeInfoTablePressedToGetInfo(arg0);
			}
		});
		typeInfoTable.setFont(new Font("宋体", Font.PLAIN, 19));
		typeInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u63CF\u8FF0" }));
		scrollPane.setViewportView(typeInfoTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		this.setLocationRelativeTo(null);// 窗口居中
		// 类别信息表格初始化
		fillTypeInfoTable(null);
	}

	/**
	 * 类别信息删除事件
	 */
	private void typeInfoDeleteActionPerformed(ActionEvent e) {
		// 1. 获取数据
		String typeId = typeIdText.getText();
		String typeName = typeNametText.getText();
		// 2. 校验数据
		if (ToolUtils.isEmpty(typeId)) {
			JOptionPane.showMessageDialog(null, "编号不能为空！");
			return;
		} else if (ToolUtils.isEmpty(typeName)) {
			JOptionPane.showMessageDialog(null, "类别名称不能为空！");
			return;
		} else if (!ToolUtils.isPositiveInteger(typeId)) {
			JOptionPane.showMessageDialog(null, "编号格式有误！");
			return;
		}
		Integer typeIdInt = Integer.parseInt(typeId);
		// 二次确认
		int result = JOptionPane.showConfirmDialog(null, "是否删除?(无法恢复)");
		if (result != 0) {
			return;
		}

		// 3. 判断是否可删除
		Connection con = DBUtils.getConnection();
		Boolean isExiset = bookDao.isExistByTypeId(con, typeIdInt);
		if (isExiset) {
			JOptionPane.showMessageDialog(null, "该类别下有图书，请处理后再进行删除！");
			return;
		}
		// 4. 执行操作
		Connection con1 = DBUtils.getConnection();
		Boolean isDelete = bookTypeDao.deleteByIdAndName(con1, typeIdInt, typeName);
		if (isDelete) {
			JOptionPane.showMessageDialog(null, "删除成功！");
			// 5.重置文本
			resetUpdateTypeInfo();
			// 6. 刷新类别删除窗口 类别查询信息
			fillTypeInfoTable(null);
			// 7. 刷新主窗口 类别查询信息
			rootMainFrame.fillTypeInfoTable(null);
		} else {
			JOptionPane.showMessageDialog(null, "删除失败 请检查删除信息！");
			return;
		}

	}

	/**
	 * 重置添加类别界面 文本信息方法
	 */
	private void resetUpdateTypeInfo() {
		typeIdText.setText("");
		typeNametText.setText("");
	}

	/*
	 * 表格行点击事件处理
	 */
	private void typeInfoTablePressedToGetInfo(MouseEvent arg0) {
		Integer row = typeInfoTable.getSelectedRow();
		// 修改信息组件
		typeIdText.setText((String) typeInfoTable.getValueAt(row, 0));
		typeNametText.setText((String) typeInfoTable.getValueAt(row, 1));
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
