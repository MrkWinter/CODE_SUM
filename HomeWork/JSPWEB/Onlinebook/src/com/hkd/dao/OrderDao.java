package com.hkd.dao;

import java.util.ArrayList;

import com.hkd.entity.ProItInven;

public interface OrderDao {
	
	
	
	public void orderInfo(int orderid,String userid,String orderdate,String baddr1,String baddr2,String bcity,
			String bstate,String bzip,String bcountry,String saddr1,String saddr2,String scity,
			String sstate,String szip,String scountry,String courier,double totalprice,String bfn,String bln,String sfn,String sln,
			String creditcard,String exprdate,String cardtype,String locale,int linenum,ArrayList<ProItInven> list);

}
