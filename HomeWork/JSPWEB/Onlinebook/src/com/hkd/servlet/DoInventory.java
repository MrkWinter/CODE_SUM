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

/**
 * Servlet implementation class DoInventory
 */
@WebServlet("/DoInventory")
public class DoInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� itemid  
		String itemid=request.getParameter("itemid");
		
		ProItInvenDaoImp pi=new ProItInvenDaoImp();
		ArrayList<ProItInven> plist=pi.getItInProByItemid(itemid);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("itinvenpro", plist.get(0));
		
		response.sendRedirect("inventory.jsp");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
