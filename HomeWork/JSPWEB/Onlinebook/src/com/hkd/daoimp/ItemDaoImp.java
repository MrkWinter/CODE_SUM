package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hkd.dao.ItemDao;
import com.hkd.util.DataBase;

public class ItemDaoImp extends DataBase implements ItemDao {

	
	public ArrayList<HashMap> getInfoByPid(String productid) {
		
		String sql="select itemid,item.productid,attr1,name,listprice from product join item on "
				+ "product.productid=item.productid where product.productid='"+productid+"'";
		ArrayList<HashMap> pilist=new ArrayList<HashMap>();
		ResultSet rs=this.getResult(sql);
		
		try {
			while(rs.next())
			{
				HashMap map=new HashMap();
				
				map.put("itemid", rs.getString("itemid"));
				map.put("productid", rs.getString("productid"));
				map.put("attr1", rs.getString("attr1"));
				map.put("name", rs.getString("name"));
				map.put("listprice", rs.getDouble("listprice"));
				
				pilist.add(map);		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pilist;
	}

}
