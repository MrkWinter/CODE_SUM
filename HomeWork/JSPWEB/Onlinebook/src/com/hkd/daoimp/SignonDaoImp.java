package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hkd.dao.SignonDao;
import com.hkd.entity.Signon;
import com.hkd.util.DataBase;

public class SignonDaoImp extends DataBase implements SignonDao{

	@Override
	public ArrayList<Signon> checkByName(String username, String password) {
    String sql="select * from signon where username='"+username+"' and password='"+password+"'";
		
		ArrayList<Signon> list=new ArrayList<Signon> ();
		ResultSet rs=this.getResult(sql);
		try {
			while(rs.next())
			{
				Signon signon=new Signon();
				signon.setUserName(rs.getString("username"));
				signon.setPassword(rs.getString("password"));
				list.add(signon);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

	@Override
	public void insertSignon(String username, String password) throws SQLException {
		String sql="insert into signon values('"+username+"','"+password+"')";
		this.executeDML(sql);
		
		}



	@Override
	public ArrayList<Signon> getAllSignon() {
		
	    String sql="select * from signon";
			
			ArrayList<Signon> list=new ArrayList<Signon> ();
			ResultSet rs=this.getResult(sql);
			try {
				while(rs.next())
				{
					Signon signon=new Signon();
					signon.setUserName(rs.getString("username"));
					signon.setPassword(rs.getString("password"));
					list.add(signon);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		
	}



	@Override
	public void updateSignon(String uname,String pwd) throws SQLException {
		String sql="update signon set password='"+pwd+"' where username='"+uname+"'";
		this.executeDML(sql);
		
	}



	@Override
	public void deleteSignon(String uname) throws SQLException {
		String sql="delete from signon where username='"+uname+"'";
		this.executeDML(sql);
		
	}



	@Override
	public ArrayList<Signon> checkByName(String username) {

	    String sql="select * from signon where username='"+username+"'";			
			ArrayList<Signon> list=new ArrayList<Signon> ();
			ResultSet rs=this.getResult(sql);
			try {
				while(rs.next())
				{
					Signon signon=new Signon();
					signon.setUserName(rs.getString("username"));
					signon.setPassword(rs.getString("password"));
					list.add(signon);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;		
	}	

}
