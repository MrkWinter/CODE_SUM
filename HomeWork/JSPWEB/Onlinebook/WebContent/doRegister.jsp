<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.SignonDaoImp" %>
<%@ page import="com.hkd.daoimp.AccountDaoImp" %>
<%@ page import="com.hkd.util.DataBase" %>
<%@ page import="java.sql.SQLException" %>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");	
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");			
String fname=request.getParameter("firstname");
String lname=request.getParameter("lastname");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String addr1=request.getParameter("addr1");
String addr2=request.getParameter("addr2");
String city=request.getParameter("city");
String state=request.getParameter("state");
String zip=request.getParameter("zip");
String country=request.getParameter("country");
System.out.println(fname);		
SignonDaoImp sdi=new SignonDaoImp();
AccountDaoImp adi=new AccountDaoImp();		
try {
	DataBase.conn.setAutoCommit(false);			
	sdi.insertSignon(uname, pwd);			
	adi.insertAccount(uname, email, fname, lname, addr1, addr2, city, state, zip, country, phone);			
	DataBase.conn.commit();
	out.print("<script>alert('right')</script>");					
	out.print("<script>window.location.href='login.jsp'</script>");
} catch (SQLException e) {
	try {
		System.out.println("插入有误，进行回滚");
		DataBase.conn.rollback();
		out.print("<script>alert('wrong')</script>");				
		out.print("<script>window.location.href='register.jsp'</script>");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

%>