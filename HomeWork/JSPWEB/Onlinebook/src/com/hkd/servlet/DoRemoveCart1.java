package com.hkd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hkd.daoimp.CartDaoImp;
import com.hkd.entity.Cart;

/**
 * Servlet implementation class DoRemoveCart1
 */
@WebServlet("/DoRemoveCart1")
public class DoRemoveCart1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRemoveCart1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 接收itemid,根据itemid找到待移除的对象，从购物车列表中移除该对象
		 */
		// 接收itemid
		String itemid=request.getParameter("itemid");
		//根据itemid找到待移除的对象
		CartDaoImp cdi=new CartDaoImp();
		Cart cart=cdi.getCartByItemid(itemid);
		//从购物车列表中移除该对象
		HttpSession session=request.getSession();
		//得到购物车列表
		ArrayList<Cart> clist=(ArrayList<Cart>) session.getAttribute("cartlist");
		
		//clist.remove(cart);
	/*	int i,m=0;
		for(i=0;i<clist.size();i++)
		{
			if(clist.get(i).getItemid().equals(cart.getItemid()))
			{
				m=i;break;//找到待删除元素的索引号
			}
		}		
		clist.remove(m);*/
		for(Cart c:clist)
		{
			if(c.getItemid().equals(cart.getItemid()))
			{
				clist.remove(c);break;
			}
			
			
			
			
			
		}
		
		
		
		
		response.sendRedirect("cart.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
