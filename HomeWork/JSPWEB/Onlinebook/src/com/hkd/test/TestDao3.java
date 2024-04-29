package com.hkd.test;

import java.sql.SQLException;

import org.junit.Test;

import com.hkd.daoimp.SignonDaoImp;
import com.hkd.util.*;
public class TestDao3 {
	
	@Test
	public void testShiwu()
	{
		//锟斤拷锟绞癸拷锟斤拷锟斤拷锟斤拷锟斤拷
		/**
		 * 1.锟斤拷锟皆讹拷锟结交锟斤拷为锟街讹拷锟结交
		 * 2.sql锟斤拷锟斤拷
		 * 3.锟斤拷锟斤拷锟街讹拷锟结交
		 * 
		 * 4.锟斤拷锟斤拷写锟斤拷锟叫回癸拷
		 * 
		 * 
		 */
		SignonDaoImp sdi=new SignonDaoImp();
		//1.锟斤拷锟皆讹拷锟结交锟斤拷为锟街讹拷锟结交
		try {
			DataBase.conn.setAutoCommit(false);
			//2.sql锟斤拷锟斤拷
			sdi.insertSignon("rose2", "123456");
			sdi.insertSignon("jack123456789", "123");
			DataBase.conn.commit();
		} catch (SQLException e) {
			try {
				System.out.println("锟斤拷锟叫回癸拷");
				DataBase.conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
