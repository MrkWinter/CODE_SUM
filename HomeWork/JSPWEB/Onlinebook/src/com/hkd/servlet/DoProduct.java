package com.hkd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hkd.daoimp.ProductDaoImp;
import com.hkd.entity.Product;

/**
 * Servlet implementation class DoProduct
 */
@WebServlet("/DoProduct")
public class DoProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catid=null;
	
		System.out.println(catid);
		ProductDaoImp pdi=new ProductDaoImp();
		HttpSession session=request.getSession();
		
		
		if(session.getAttribute("catid")==null||request.getParameter("cid")!=null)
			catid=request.getParameter("cid");
		else
			catid=(String) session.getAttribute("catid");
		
		
		
		//�õ���ӛ䛔�
		int count=pdi.getCount(catid);
		//Ӌ�㿂퓴a
		int pageCount=0;
		if(count%5==0)
			pageCount=count/5;
		else
			pageCount=count/5+1;
		
		//pageNo
		int pageNo=0;
		/*int pageNo=0;
		pageNo=session.getAttribute("")*/
		if(session.getAttribute("pageNo")==null)
		{
			pageNo=1;
		}
		else
		{
			pageNo=(int) session.getAttribute("pageNo");
		}
		String flag=request.getParameter("flag");
		if("up".equals(flag))//flag.equals("up")
		{
			if(pageNo<pageCount)
			pageNo++;
			else
				pageNo=pageCount;
		}
		else if("down".equals(flag))
		{
			if(pageNo>1)
			pageNo--;
			else
				pageNo=1;
		}
	
		session.setAttribute("pageNo", pageNo);
		
		ArrayList<Product> plist=pdi.getProductByCategoryByPage(catid, pageNo, 5);
		
		session.setAttribute("plist", plist);
		session.setAttribute("catid", catid);
		response.sendRedirect("product.jsp");
		
		
		
		
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
