package com.hkd.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hkd.dao.CartDao;
import com.hkd.entity.Cart;
import com.hkd.util.DataBase;

public class CartDaoImp extends DataBase implements CartDao {

	@Override
	public Cart getCartByItemid(String itemid) {
		String sql="select item.itemid,product.productid,attr1,name,qty,listprice from product join item on "
				+ " product.productid=item.productid join inventory on item.itemid=inventory.itemid "
				+ " where item.itemid='"+itemid+"'";
		ResultSet rs=this.getResult(sql);
		Cart cart=null;
		try {
			rs.next();
			String iid=rs.getString("itemid");
			String productid=rs.getString("productid");
			String attr1=rs.getString("attr1");
			String name=rs.getString("name");
			int qty=rs.getInt("qty");
			double listprice=rs.getDouble("listprice");
			cart=new Cart(itemid, productid, attr1, name, qty, 1, listprice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return cart;
	}

}
