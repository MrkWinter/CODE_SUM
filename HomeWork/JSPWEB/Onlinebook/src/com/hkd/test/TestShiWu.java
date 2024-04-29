package com.hkd.test;

import java.sql.SQLException;

import org.junit.Test;

import com.hkd.daoimp.SignonDaoImp;
import com.hkd.util.DataBase;

public class TestShiWu {
	
	@Test
	public void test1()
	{
		SignonDaoImp sdi=new SignonDaoImp();
		//1.锟斤拷锟皆讹拷锟结交为锟街讹拷锟结交
		try {
			DataBase.conn.setAutoCommit(false);
			//2.锟斤拷锟斤拷DDM  SQL锟斤拷锟斤拷
			sdi.insertSignon("tom", "123");
			
			sdi.insertSignon("jack1123233333", "123");
			//3.3.锟斤拷锟斤拷锟街讹拷锟结交
			DataBase.conn.commit();
			System.out.println("锟斤拷锟斤拷晒锟�");
		} catch (SQLException e) {
			if(DataBase.conn!=null)
				try {
			//4.锟斤拷锟斤拷锟斤拷锟斤拷斐ｏ拷锟斤拷谢毓锟�
					System.out.println("锟斤拷锟叫回癸拷");
					DataBase.conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		
		
	}

}
