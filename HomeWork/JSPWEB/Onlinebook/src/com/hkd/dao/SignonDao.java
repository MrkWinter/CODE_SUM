package com.hkd.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hkd.entity.Signon;



public interface SignonDao {
	
	public ArrayList<Signon> checkByName(String username,String password);
	
	public ArrayList<Signon> checkByName(String username);
	
	public void insertSignon(String username,String password) throws SQLException;
	
	public ArrayList<Signon> getAllSignon();
	
	public void updateSignon(String uname,String pwd) throws SQLException;
	
	public void deleteSignon(String uname) throws SQLException;

}
