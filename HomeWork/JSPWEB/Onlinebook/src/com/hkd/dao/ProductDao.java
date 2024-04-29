package com.hkd.dao;

import java.util.ArrayList;

import com.hkd.entity.Product;

public interface ProductDao {
//(1)��ѯproduct�����м�¼
	public ArrayList<Product> getProduct();
	//(2)����productid��ѯproduct��
	public ArrayList<Product> getProductByproductID(String cardnum);
	//(3)����productid���и���
	public void updateProduct(String cardnum);
	
	public ArrayList<Product> getProductByCategory(String category);
	
	//��ҳ����
	public ArrayList<Product> getProductByCategoryByPage(String category,int pageNo,int pageSize);
	//count
	public int getCount(String category);
	//�������� �µķ�ҳ����
	public ArrayList<Product> getProductByCategoryByPage(String name,int pageNo);
	//count
	public int getCountByName(String name);
	
	
}
