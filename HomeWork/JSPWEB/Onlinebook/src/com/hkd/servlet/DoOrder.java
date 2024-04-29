package com.hkd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DoOrder")
public class DoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DoOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		String cardty=request.getParameter("cardty");
		String cardnum=request.getParameter("cardnum");
		String exdate=request.getParameter("exdate");
		session.setAttribute("cardty", cardty);
		session.setAttribute("cardnum", cardnum);
		session.setAttribute("exdate", exdate);
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		
		session.setAttribute("sfname",fname);
		session.setAttribute("slname",lname);
		session.setAttribute("saddr1",addr1);
		session.setAttribute("saddr2",addr2);
		session.setAttribute("scity",city);
		session.setAttribute("sstate",state);
		session.setAttribute("szip",zip);
		session.setAttribute("scountry",country);
		
		String s=request.getParameter("ck");
		if(cardty!="" && cardnum!="" && exdate!="")		
		{
		   if("yes".equals(s))
		  {
		 	response.sendRedirect("changeOrderInfoNew.jsp");
		  }
		  else 
		  {
	    	response.sendRedirect("checkOrderInfoNew.jsp");
		  }
		
		}
		
		else
			response.sendRedirect("orderNew.jsp");
			
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
