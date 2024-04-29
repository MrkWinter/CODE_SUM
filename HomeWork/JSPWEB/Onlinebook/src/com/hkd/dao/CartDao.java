package com.hkd.dao;

import com.hkd.entity.Cart;

public interface CartDao {
	//抽象出对数据表 进行的操作
	//找到待添加商品（图书）
	public Cart getCartByItemid(String itemid);
	

}
