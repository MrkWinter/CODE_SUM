package com.hkd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hkd.entity.Cart;

/**
 * Servlet implementation class DoUpdateCart1
 */
@WebServlet("/DoUpdateCart1")
public class DoUpdateCart1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUpdateCart1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.接收文本框中的数据（购买数量） 2.重置购物车列表中商品的购买数量
		 * 3.计算每个商品的总价      4.计算所有商品的总价
		 */
		HttpSession session=request.getSession();
		ArrayList<Cart> clist=(ArrayList<Cart>) session.getAttribute("cartlist");
		
		int i=0;
		double sum=0;
		double total=0;
		for(Cart c:clist)
		{
		//1.接收文本框中的数据（购买数量）	
		String qty[]=request.getParameterValues("qty");	
		int qty_int=Integer.parseInt(qty[i]);
		
		c.setBuyqty(qty_int);
		sum=c.getBuyqty()*c.getListprice();	//每个商品的总价
		total=total+sum;
		
		
		
		
		
		i++;
		}
		
		session.setAttribute("total", total);
		
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
