package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hkd.dao.CategoryDao;
import com.hkd.entity.Category;
import com.hkd.util.DataBase;

public class CategoryDaoImp extends DataBase implements CategoryDao {

	@Override
	public ArrayList<Category> getCategory() {
		//(1)��ȡcategory�����м�¼
		String sql="select * from category";
		ResultSet rs=this.getResult(sql);
		ArrayList<Category> slist=new ArrayList<Category>();
		try {
			while(rs.next()) {
				String cardid=rs.getString("catID");
				String uname=rs.getString("name");
				String bookdescn=rs.getString("descn");
				Category category=new Category();
				category.setCatID(cardid);
				category.setName(uname);
				category.setDescn(bookdescn);
				slist.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public void insertCategory(String cardid, String uname, String bookdescn) {
		// (2)��category���в������
		String sql="insert into category values('"+cardid+"','"+uname+"','"+bookdescn+"')";
		//this.executeDML(sql);
	}

}
