package com.hkd.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface InventoryDao {
	
	public ArrayList<HashMap> checkInfoByIid(String itemid);

}
