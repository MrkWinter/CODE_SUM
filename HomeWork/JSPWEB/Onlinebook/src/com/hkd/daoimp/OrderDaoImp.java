package com.hkd.daoimp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hkd.dao.OrderDao;
import com.hkd.entity.ProItInven;
import com.hkd.util.DataBase;
public class OrderDaoImp extends DataBase implements OrderDao{	
	public void orderInfo(int orderid,String userid,String orderdate,String saddr1,String saddr2,String scity,
			String sstate,String szip,String scountry, String baddr1,String baddr2, String bcity, String bstate, 
			String bzip,String bcountry,String courier,double totalprice,String bfn,String bln,String sfn,String sln,
			String creditcard,String exprdate,String cardtype,String locale,int linenum, ArrayList<ProItInven> list) {		
		Connection conn=this.conn;
		System.out.println(scountry);
		String sql1="insert into orders values("+orderid+",'"+userid+"', '"+orderdate+"' ,'"+saddr1+"','"+saddr2+"',"
				+ "'"+scity+"','"+sstate+"','"+szip+"','"+scountry+"','"+baddr1+"',"+ "'"+baddr2+"','"+bcity+"','"+bstate+"','"+bzip+"',"
			    + "'"+bcountry+"','"+courier+"',"+totalprice+",'"+bfn+"','"+bln+"','"+sfn+"','"+sln+"','"+creditcard+"','"+exprdate+"',"
			    		+ "'"+cardtype+"','"+locale+"')";		
		String sql2="insert into orderstatus values("+orderid+","+linenum+",'"+orderdate+"','p')";		
		String sql3=null;
		String sql4=null;		
		try {
			conn.setAutoCommit(false);			
			this.executeDML(sql1);
			this.executeDML(sql2);			
			for(ProItInven pii:list)
			{
				sql3="insert into lineitem values("+orderid+","+linenum+","
						+ "'"+pii.getItemid()+"', '"+pii.getBuyqty()+"','"+pii.getListprice()+"')";				
				sql4="update inventory set QTY=qty-'"+pii.getQty()+"' where itemid='"+pii.getItemid()+"'";
				this.executeDML(sql3);
				this.executeDML(sql4);
				System.out.println("插入成功");				
			}			
			conn.commit();
		} catch (SQLException e) {
			
			try {
				
				System.out.println("插入失败");
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
