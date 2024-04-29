<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.SignonDaoImp" %>
<%@ page import="com.hkd.entity.Signon" %>
<%@ page import="java.util.ArrayList" %>
<%
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");
SignonDaoImp sdi=new SignonDaoImp();
ArrayList<Signon> slist=sdi.checkByName(uname, pwd);
if(slist.size()>=1)
{
	session.setAttribute("user", uname);
	session.setAttribute("login", "login");
	response.sendRedirect("DoIndex");
}
else
{
	session.setAttribute("info", "您输入的用户名或密码不存在，请重新输入或注册");
	response.sendRedirect("login.jsp");
}
%>