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
 * Servlet implementation class DoProduct2
 */
@WebServlet("/DoProduct2")
public class DoProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoProduct2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String catid=null;
	
		
		ProductDaoImp pdi=new ProductDaoImp();
		HttpSession session=request.getSession();
		
		
		if(session.getAttribute("catid")==null||request.getParameter("cid")!=null)
			catid=request.getParameter("cid");
		else
			catid=(String) session.getAttribute("catid");
		
		System.out.println(catid);
		
		//�õ���ӛ䛔�
		int count=pdi.getCount(catid);
		//Ӌ�㿂퓴a
		int pageCount=0;
		if(count%5==0)
			pageCount=count/5;
		else
			pageCount=count/5+1;
		//Ӌ�㿂�ֽM��
		int pageGroupCount=0;
		if(pageCount%5==0)
			pageGroupCount=pageCount/5;
		else
			pageGroupCount=pageCount/5+1;
		
		
		
		
		int pageNo=0;
		String str=request.getParameter("pageNo");
		if(str!=null)
			pageNo=Integer.parseInt(str);
		if(session.getAttribute("pageNo")==null)
		{
			pageNo=1;
		}
		else if(request.getParameter("pageNo")==null)
			pageNo=(int) session.getAttribute("pageNo");
		
		//��퓴a�ķֽM
		int pageGroupNo=0;
		if(session.getAttribute("pageGroupNo")==null)
		{
			pageGroupNo=0;
		}
		else
		{
			pageGroupNo=(int) session.getAttribute("pageGroupNo");
		}
		String flag=request.getParameter("flag");
		if("up".equals(flag))
		{
			if(pageGroupNo<pageGroupCount-1)
			pageGroupNo++;
			else
				pageGroupNo=pageGroupCount-1;
		}
		else if("down".equals(flag))
		{
			if(pageGroupNo>=1)
				pageGroupNo--;
				else
					pageGroupNo=0;
		}
		
		ArrayList<ArrayList> clist=new ArrayList<ArrayList>();
		for(int i=1;i<=pageCount;i+=5)
		{
			ArrayList<Integer> tlist=new ArrayList<Integer>();
			for(int j=i;j<=i+4;j++)
			{
				if(j<=pageCount)
				tlist.add(j);
			}
			clist.add(tlist);
		}		
		System.out.println(pageGroupNo);
		session.setAttribute("pageGroupNum", clist.get(pageGroupNo));
		session.setAttribute("pageGroupNo",pageGroupNo); 
		session.setAttribute("pageNo", pageNo);
		
		ArrayList<Product> plist=pdi.getProductByCategoryByPage(catid, pageNo, 5);
		
		session.setAttribute("plist", plist);
		session.setAttribute("catid", catid);
		response.sendRedirect("product2.jsp");
		
		
		
		
	
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
