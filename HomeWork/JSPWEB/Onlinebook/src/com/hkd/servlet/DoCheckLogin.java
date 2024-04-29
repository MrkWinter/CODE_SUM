package com.hkd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hkd.daoimp.AccountDaoImp;
import com.hkd.entity.Account;


@WebServlet("/DoCheckLogin")
public class DoCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoCheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		
		
		
		if("login".equals(session.getAttribute("login")))
		{
			AccountDaoImp asi=new AccountDaoImp();
			
			String userid=(String) session.getAttribute("user");
			System.out.println(userid);
			ArrayList<Account> list=asi.selectAccount(userid);
		
			String firstname=null;
			String lastname=null;
			String addr1=null;
			String addr2=null;
			String city=null;
			String state=null;
			String zip=null;
			String country=null;
			
			for(Account a:list)
			{
				firstname=a.getFirstname();
				lastname=a.getLastname();
				addr1=a.getAddr1();
				addr2=a.getAddr2();
				city=a.getCity();
				state=a.getState();
				zip=a.getZip();
				country=a.getCountry();
			}
			session.setAttribute("fname", firstname);
			session.setAttribute("lname", lastname);
			session.setAttribute("addr1", addr1);
			session.setAttribute("addr2", addr2);
			session.setAttribute("city", city);
			session.setAttribute("state", state);
			session.setAttribute("zip", zip);
			session.setAttribute("country", country);
			
			
			
				response.sendRedirect("orderNew.jsp");
		}
		else 
			response.sendRedirect("login.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
