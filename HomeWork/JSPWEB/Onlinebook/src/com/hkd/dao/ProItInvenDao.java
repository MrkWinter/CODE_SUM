package com.hkd.dao;

import java.util.ArrayList;

import com.hkd.entity.ProItInven;



public interface ProItInvenDao {	
	public ArrayList<ProItInven> getItInProByItemid(String itemid);
	public ArrayList<ProItInven> selectCart(String itemid);
}
