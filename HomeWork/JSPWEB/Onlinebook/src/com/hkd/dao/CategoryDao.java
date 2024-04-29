package com.hkd.dao;

import java.util.ArrayList;

import com.hkd.entity.Category;

public interface CategoryDao {
//(1)��ѯcategory�����м�¼
	public ArrayList<Category> getCategory();
	//(2) ��category���в������
	public void insertCategory(String cardid,String uname,String bookdescn);
}
