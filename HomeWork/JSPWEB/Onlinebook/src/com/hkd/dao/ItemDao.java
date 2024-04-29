package com.hkd.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemDao {
	
	public ArrayList<HashMap> getInfoByPid(String productid);

}
