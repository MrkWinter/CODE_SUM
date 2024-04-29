package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hkd.dao.ProItInvenDao;
import com.hkd.entity.ProItInven;
import com.hkd.util.DataBase;
public class ProItInvenDaoImp extends DataBase implements ProItInvenDao{	
	public ArrayList<ProItInven> selectCart(String itemid) {		
		String sql="select item.itemid,product.productid,attr1,name,qty,listprice from product join item on "
			+ " product.productid=item.productid join inventory on item.itemid=inventory.itemid "
			+ " where item.itemid='"+itemid+"'";	
	ArrayList<ProItInven> list=new ArrayList<ProItInven>();
	ResultSet rs=this.getResult(sql);	
	try {
		while(rs.next())
		{
			ProItInven pi=new ProItInven();
			pi.setItemid(rs.getString("itemid"));
			pi.setProductid(rs.getString("productid"));
			pi.setAttr1(rs.getString("attr1"));
			pi.setName(rs.getString("name"));
			pi.setQty(rs.getInt("qty"));
			pi.setListprice(rs.getDouble("listprice"));			
			pi.setBuyqty(1);						
			list.add(pi);
		}
	} catch (SQLException e) {		
			e.printStackTrace();
		}	
		return list;			
	}	
public ArrayList<ProItInven> getItInProByItemid(String itemid) {		
		String sql="select attr4,item.itemid,name,qty,unitcost from item"
			   +" join product"+
			     " on item.productid=product.productid"+
			    " join inventory"+
			     " on item.itemid=inventory.itemid"+
			     " where item.itemid='"+itemid+"'";	
	ArrayList<ProItInven> list=new ArrayList<ProItInven>();
	ResultSet rs=this.getResult(sql);	
	try {
		while(rs.next())
		{
			ProItInven pi=new ProItInven();
			pi.setItemid(rs.getString("itemid"));			
			pi.setAttr4(rs.getString("attr4"));
			pi.setName(rs.getString("name"));
			pi.setQty(rs.getInt("qty"));
			pi.setUnitprice(rs.getDouble("unitcost"));					
			list.add(pi);
		}
	} catch (SQLException e) {		
			e.printStackTrace();
		}	
		return list;		
	}
}
