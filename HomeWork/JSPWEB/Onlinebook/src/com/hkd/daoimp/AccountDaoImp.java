package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hkd.dao.AccountDao;
import com.hkd.entity.Account;
import com.hkd.util.DataBase;



public class AccountDaoImp extends DataBase implements AccountDao{

	@Override
	public void insertAccount(String userid, String email, String firstname,
			String lastname, String addr1, String addr2, String city,
			String state, String zip, String country, String phone) throws SQLException {
		
		String sql=" insert into account(userid,email,firstname,lastname,addr1,addr2,city,state,zip,"
				+ "country,phone) values('"+userid+"','"+email+"','"+firstname+"','"+lastname+"',"
				+ "'"+addr1+"','"+addr2+"','"+city+"','"+state+"','"+zip+"','"+country+"','"+phone+"')";
		
		
			this.executeDML(sql);
		
		
	}

	public ArrayList<Account> selectAccount(String userid) {
		
		String sql="select * from account where userid='"+userid+"'";
		
		ResultSet rs=this.getResult(sql);
		
		ArrayList<Account> list=new ArrayList<Account>();
		
		
		
			try {
				while(rs.next())
				{
					Account account=new Account();
					account.setUserid(rs.getString("userid"));
					account.setEmail(rs.getString("email"));
					account.setFirstname(rs.getString("firstname"));
					account.setLastname(rs.getString("lastname"));
					account.setAddr1(rs.getString("addr1"));
					account.setAddr2(rs.getString("addr2"));
					account.setCity(rs.getString("city"));
					account.setState(rs.getString("state"));
					account.setZip(rs.getString("zip"));
					account.setCountry(rs.getString("country"));
					account.setPhone(rs.getString("phone"));
					list.add(account);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return list;
	}

}
