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
 * Servlet implementation class DoProduct3
 */
@WebServlet("/DoProduct3")
public class DoProduct3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoProduct3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=null;
		HttpSession session=request.getSession();
		if(request.getParameter("pname")!=null)
		{
			name=request.getParameter("pname");
			session.setAttribute("pname", name);
		}
		else
			name=(String) session.getAttribute("pname");//����ڶ����Ժ�name�Ļ�ȡ����
		
		ProductDaoImp pdi=new ProductDaoImp();
		
		/**
		 * 1.��Ҫ������ҳ������������ÿ5�����з��顣
a[6]={{1,2,3,4,5},{6,7,8,,9,10},{},{},{},{}};
2.�����û����������ǰ�����ļ�ͷ����̬�ĸ��� 
�����--
�����++
3.a[�����]
4.session.setAttribute("pageGroupNum",a[�����])
		 */
		int count=pdi.getCountByName(name);//����ܼ�¼��
		//������ҳ��
		int pageCount=0;
		if(count%5==0)
			pageCount=count/5;
		else
			pageCount=count/5+1;//������ҳ��
		//�ܷ�����
		int pageGroupCount=0;
		if(pageCount%5==0)
			pageGroupCount=pageCount/5;
		else
			pageGroupCount=pageCount/5+1;//�ܷ�����
		//��������
		int pageGroupNo=0;
		//
		if(session.getAttribute("pageGroupNo")==null)
			pageGroupNo=0;
		else
			pageGroupNo=(int) session.getAttribute("pageGroupNo");
		
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
		}//�������ǰ����ͷ��pageGroupNo++  pageGroupNo--
			
		session.setAttribute("pageGroupNo", pageGroupNo);
		//������ÿ5�����з���洢
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
		//pageNo
		int pageNo=0;
		String str=request.getParameter("pageNo");
		if(str!=null)
			pageNo=Integer.parseInt(str);
		
		if(session.getAttribute("pageNo")==null)
             pageNo=1;
        else if(request.getParameter("pageNo")==null)
          pageNo=(int) session.getAttribute("pageNo");
			
		session.setAttribute("pageGroupNum", clist.get(pageGroupNo));
		session.setAttribute("pageNo", pageNo);	
		
		ArrayList<Product> plist=pdi.getProductByCategoryByPage(name, pageNo);//���ú����������
		
		session.setAttribute("plist", plist);
		response.sendRedirect("product3.jsp");
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
