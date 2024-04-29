package com.hkd.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hkd.daoimp.ProItInvenDaoImp;
import com.hkd.entity.ProItInven;
@WebServlet("/DoCart")
public class DoCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		HttpSession session=request.getSession(true);
		String itemid=request.getParameter("itemid");
		ProItInvenDaoImp pisi=new ProItInvenDaoImp();
		ArrayList<ProItInven> list=pisi.selectCart(itemid);
		ProItInven pii=list.get(0);
		ArrayList<ProItInven> cartlist=new ArrayList<ProItInven>();         
		boolean flag=false;		
		if(session.getAttribute("cartlist")==null)
		{	
		    cartlist.add(pii);
		}
		else
		{
			cartlist=(ArrayList<ProItInven>)session.getAttribute("cartlist");			
			for(ProItInven p:cartlist)
			{
				double total=0;
				if(p.getItemid().equals(pii.getItemid()))
				{
					flag=true;
					p.setBuyqty(p.getBuyqty()+1);
					
					total=total+p.getBuyqty()*p.getListprice();
				}
				session.setAttribute("total", total);				
			}
			if(!flag)
				cartlist.add(pii);
			}	
		session.setAttribute("cartlist",cartlist);
		response.sendRedirect("cart.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		this.doGet(req, resp);
	}
	
}
