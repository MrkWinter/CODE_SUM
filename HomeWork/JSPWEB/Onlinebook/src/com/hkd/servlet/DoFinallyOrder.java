package com.hkd.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hkd.daoimp.OrderDaoImp;
import com.hkd.entity.ProItInven;



/**
 * Servlet implementation class DoFinallyOrder
 */
@WebServlet("/DoFinallyOrder")
public class DoFinallyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFinallyOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
		ServletContext application=super.getServletContext();
		int orderid=5001;
		application.setAttribute("orderid", orderid);
		
		
		String userid=(String) session.getAttribute("user");
		
		String baddr1=(String) session.getAttribute("addr1");
		String baddr2=(String) session.getAttribute("addr2");
		String bcity=(String) session.getAttribute("city");
		String bstate=(String) session.getAttribute("state");
		String bzip=(String) session.getAttribute("zip");
		String bcountry=(String) session.getAttribute("country");
		String bfn=(String) session.getAttribute("fname");
		String bln=(String) session.getAttribute("lname");
		
		String saddr1=(String) session.getAttribute("saddr1");
		String saddr2=(String) session.getAttribute("saddr2");
		String scity=(String) session.getAttribute("scity");
		String sstate=(String) session.getAttribute("sstate");
		String szip=(String) session.getAttribute("szip");
		String scountry=(String) session.getAttribute("scountry");
		String sfn=(String) session.getAttribute("sfn");
		String sln=(String) session.getAttribute("sln");
		
		String creditcard=(String) session.getAttribute("cardnum");
		String exprdate=(String) session.getAttribute("exdate");
		String cardtype=(String) session.getAttribute("cardty");
		
		//double totalprice=(double) session.getAttribute("total");
		double totalprice=12;
		Date date=new Date();
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		String orderdate=dt.format(date);
		
		
		String courier="UPS";
		session.setAttribute("courier", courier);
		String locale="aaa";
		int linenum=1001;
		
		ArrayList<ProItInven> list=(ArrayList<ProItInven>)session.getAttribute("cartlist");
		/*for(ProItInven p:list)
		{
			
		}
		*/
		//System.out.println(orderdate);
		OrderDaoImp odi=new OrderDaoImp();
		odi.orderInfo(orderid, userid, orderdate, baddr1, baddr2, bcity, bstate, bzip, bcountry,
				saddr1,saddr2, scity, sstate, szip, scountry, courier, totalprice, bfn, bln, 
				sfn, sln, creditcard, exprdate, cardtype, locale, linenum, list);
		
		
		response.sendRedirect("finallyOrderNew.jsp");
		
	}

}
