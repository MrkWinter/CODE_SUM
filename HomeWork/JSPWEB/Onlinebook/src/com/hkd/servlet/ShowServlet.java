package com.hkd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hkd.daoimp.CategoryDaoImp;
import com.hkd.daoimp.SignonDaoImp;
import com.hkd.entity.Category;
import com.hkd.entity.Signon;


/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String index=request.getParameter("index");
		HttpSession session=request.getSession();		
		
		/*if("1".equals(index))
		{
			SignonDaoImpl sdi=new SignonDaoImpl();
			ArrayList<Signon> slist=sdi.getAllSignon();
			session.setAttribute("slist", slist);
		}
		else if("2".equals(index))
		{
			CategoryDaoImpl cdi=new CategoryDaoImpl();
			ArrayList<Category> clist=cdi.getCategory();
			session.setAttribute("clist", clist);			
		}*/
		
		
		
		
		PrintWriter out=response.getWriter();
		System.out.println(index);
		out.write(index);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
