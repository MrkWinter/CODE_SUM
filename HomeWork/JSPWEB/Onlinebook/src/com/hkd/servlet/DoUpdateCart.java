package com.hkd.servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hkd.entity.ProItInven;
@WebServlet("/DoUpdateCart")
public class DoUpdateCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		HttpSession session=request.getSession(true);
		ArrayList<ProItInven> cartlist=new ArrayList<ProItInven>();
		if(session.getAttribute("cartlist")!=null)
		{	
			cartlist=(ArrayList<ProItInven>)session.getAttribute("cartlist");
		}
		 
		    int i=0;
			double total=0;
			for(ProItInven p:cartlist)
			{
				String qty=request.getParameter("qty"+i);
				int bqty=Integer.parseInt(qty);
				p.setBuyqty(bqty);
				i++;					
				total=total+bqty*p.getListprice();				
			}			
		session.setAttribute("total", total);
		response.sendRedirect("cart.jsp");
	}
}
