package com.hkd.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import com.hkd.daoimp.ProductDaoImp;
import com.hkd.entity.Product;

public class TestDao1 {
	@Test
	public void testSelect() {
		// 锟斤拷1锟斤拷锟斤拷锟斤拷锟斤拷锟�product锟斤拷锟斤拷锟叫硷拷录锟侥斤拷锟斤拷锟�	
ProductDaoImp pdi=new ProductDaoImp();
ArrayList<Product> slist=pdi.getProductByCategoryByPage("03", 2, 2);
for(Product product:slist) {
	System.out.println(product.getProductID()+"\t"+product.getCategory()+"\t"+product.getName()+"\t"+product.getDescn());
}

	}
	@Test
	public void testSelect1() {
		// (2)锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�productid锟斤拷询product锟斤拷
		Scanner input=new Scanner(System.in);
		System.out.println("锟斤拷锟斤拷锟斤拷leibie锟斤拷牛锟�");
		String cardnum=input.next();
		ProductDaoImp pdi=new ProductDaoImp();	
		ArrayList<Product> slist=pdi.getProductByCategory(cardnum);
		for(Product product:slist) {
			System.out.println(product.getProductID()+"\t"+product.getCategory()+"\t"+product.getName()+"\t"+product.getDescn());	
		}
		
	}
	@Test
	public void testUpdate() {
		Scanner input=new Scanner(System.in);
		System.out.print("锟斤拷锟斤拷锟斤拷图锟斤拷锟脚ｏ拷");
		String cardnum=input.next();
		ProductDaoImp sdi=new ProductDaoImp();
		sdi.updateProduct(cardnum);
		
	}
}
