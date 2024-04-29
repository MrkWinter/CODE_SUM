package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.hkd.dao.ProductDao;
import com.hkd.entity.Product;
import com.hkd.util.DataBase;

public class ProductDaoImp extends DataBase implements ProductDao{

	@Override
	public ArrayList<Product> getProduct() {
		// 锟斤拷1锟斤拷锟斤拷取product锟斤拷锟斤拷锟叫硷拷录锟侥斤拷锟斤拷锟�
		String sql="select * from product";
		ResultSet rs=this.getResult(sql);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟捷达拷锟斤拷ArrarList锟斤拷
		ArrayList<Product> slist=new ArrayList<Product>();
		try {
			while(rs.next()) {
				String cardnum=rs.getString("productID");
				String caid=rs.getString("category");
				String bookname=rs.getString("name");
				String bookdescn=rs.getString("descn");
			Product product=new Product();
			product.setProductID(cardnum);
			product.setCategory(caid);
			product.setName(bookname);
			product.setDescn(bookdescn);
			slist.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public ArrayList<Product> getProductByproductID(String cardnum) {
		// (2)锟斤拷取锟斤拷锟斤拷productid锟斤拷询product锟斤拷
		String sql="select * from product where productID='"+cardnum+"'";
       // this.executeDML(sql);
		ResultSet rs=this.getResult(sql);
		//锟窖斤拷锟斤拷锟斤拷娲拷锟紸rrayList锟斤拷
		ArrayList<Product> slist=new ArrayList<Product>();
		try {
			while(rs.next()) {
				String cardnum1=rs.getString("productID");
				String caid=rs.getString("category");
				String bookname=rs.getString("name");
				String bookdescn=rs.getString("descn");
			Product product=new Product();
			product.setProductID(cardnum1);
			product.setCategory(caid);
			product.setName(bookname);
			product.setDescn(bookdescn);
			slist.add(product);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public void updateProduct(String cardnum) {
		// (3)锟斤拷锟斤拷productid锟斤拷锟叫革拷锟斤拷		
		String sql="update product set category='1005',name='英锟斤拷'   where productID='"+cardnum+"' ";
		//this.executeDML(sql);
		//ResultSet rs=this.getResult(sql);
	}

	@Override
	public ArrayList<Product> getProductByCategory(String category) {

		// (2)锟斤拷取锟斤拷锟斤拷productid锟斤拷询product锟斤拷
		String sql="select * from product where category='"+category+"'";
       // this.executeDML(sql);
		ResultSet rs=this.getResult(sql);
		//锟窖斤拷锟斤拷锟斤拷娲拷锟紸rrayList锟斤拷
		ArrayList<Product> slist=new ArrayList<Product>();
		try {
			while(rs.next()) {
				String cardnum1=rs.getString("productID");
				String caid=rs.getString("category");
				String bookname=rs.getString("name");
				String bookdescn=rs.getString("descn");
			Product product=new Product();
			product.setProductID(cardnum1);
			product.setCategory(caid);
			product.setName(bookname);
			product.setDescn(bookdescn);
			slist.add(product);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	
	}

	@Override
	public ArrayList<Product> getProductByCategoryByPage(String category, int pageNo, int pageSize) {
		//锟斤拷頁碉拷SQL
		String sql="select * from product where category='"+category+"'   limit "+(pageNo-1)*pageSize+","+pageSize+"";
		ResultSet rs=this.getResult(sql);
		//锟窖斤拷锟斤拷锟斤拷娲拷锟紸rrayList锟斤拷
		ArrayList<Product> slist=new ArrayList<Product>();
		try {
			while(rs.next()) {
				String cardnum1=rs.getString("productID");
				String caid=rs.getString("category");
				String bookname=rs.getString("name");
				String bookdescn=rs.getString("descn");
			Product product=new Product();
			product.setProductID(cardnum1);
			product.setCategory(caid);
			product.setName(bookname);
			product.setDescn(bookdescn);
			slist.add(product);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public int getCount(String category) {
		String sql="select count(*) from product where category='"+category+"'";
		
		ResultSet rs=this.getResult(sql);
		int count=0;
		
		try {
			rs.next();
			count=rs.getInt(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}

	@Override
	public ArrayList<Product> getProductByCategoryByPage(String name, int pageNo) {		
		String sql="select * from product where name like '%"+name+"%' limit "+(pageNo-1)*5+",5";
		ResultSet rs=this.getResult(sql);		
		ArrayList<Product> slist=new ArrayList<Product>();
		try {
			while(rs.next()) {
				String cardnum1=rs.getString("productID");
				String caid=rs.getString("category");
				String bookname=rs.getString("name");
				String bookdescn=rs.getString("descn");
			Product product=new Product();
			product.setProductID(cardnum1);
			product.setCategory(caid);
			product.setName(bookname);
			product.setDescn(bookdescn);
			slist.add(product);	
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return slist;	
	}

	@Override
	public int getCountByName(String name) {
		String sql="select count(*) from product where name like '%"+name+"%'";		
		ResultSet rs=this.getResult(sql);
		int count=0;		
		try {
			rs.next();
			count=rs.getInt(1);			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return count;
	}
	
}
