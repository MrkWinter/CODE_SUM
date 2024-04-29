package com.hkd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DoChangeOrderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoChangeOrderInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(true);
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		
		session.setAttribute("s1fname",fname);
		session.setAttribute("s1lname",lname);
		session.setAttribute("s1addr1",addr1);
		session.setAttribute("s1addr2",addr2);
		session.setAttribute("s1city",city);
		session.setAttribute("s1state",state);
		session.setAttribute("s1zip",zip);
		session.setAttribute("s1country",country);
		
		

		response.sendRedirect("checkOrderInfoNew.jsp");
		
	}

}
