package com.hkd.test;
import java.util.ArrayList;
import org.junit.Test;

import com.hkd.daoimp.CartDaoImp;
import com.hkd.daoimp.SignonDaoImp;
import com.hkd.entity.Cart;
import com.hkd.entity.Signon;


public class TestDao {
	@Test
	public void testSelect() {
		SignonDaoImp sdi = new SignonDaoImp();
		ArrayList<Signon> slist = sdi.getAllSignon();
		for (Signon signon : slist) {
			System.out.println(signon.getUserName() + "\t" + signon.getPassword());
		}
	}

@Test
public void testSelect2() {
	CartDaoImp cdi=new CartDaoImp();
	Cart cart=cdi.getCartByItemid("1002");
	
	System.out.println(cart);
	
	
	
	
}


}
