package com.hkd.test;

import java.util.ArrayList;

import org.junit.Test;

import com.hkd.daoimp.CategoryDaoImp;
import com.hkd.daoimp.ProItInvenDaoImp;
import com.hkd.entity.Category;
import com.hkd.entity.ProItInven;

public class TestDao2 {
@Test
public void testSelect() {
	// 锟斤拷1锟斤拷锟斤拷锟斤拷锟斤拷锟�category锟斤拷锟斤拷锟叫硷拷录
	CategoryDaoImp cdi=new CategoryDaoImp();
	ArrayList<Category> slist=cdi.getCategory();
	for(Category category:slist) {
		System.out.println(category.getCatID()+"\t"+category.getName()+"\t"+category.getDescn());
	}
}


@Test
public void testSelect2() {
	// 锟斤拷1锟斤拷锟斤拷锟斤拷锟斤拷锟�category锟斤拷锟斤拷锟叫硷拷录
/*	ProItInvenDaoImp pi=new ProItInvenDaoImp();
	ArrayList<ProItInven> plist=pi.getItInProByItemid("1003");
	for(ProItInven p:plist)
		System.out.println(p.getName());*/
}


@Test
public void testInsert() {
	CategoryDaoImp sdi=new CategoryDaoImp();
	sdi.insertCategory("3","英锟斤拷","null");
}
}
