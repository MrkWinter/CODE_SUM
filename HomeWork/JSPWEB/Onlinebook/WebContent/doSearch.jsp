<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.ProductDaoImp" %>
<%@ page import="com.hkd.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%
String name=null;
if(request.getParameter("pname")!=null)
{
	name=request.getParameter("pname");
	session.setAttribute("pname", name);
}
else
	name=(String) session.getAttribute("pname");
ProductDaoImp pdi=new ProductDaoImp();
int count=pdi.getCountByName(name);
int pageCount=0;
if(count%5==0)
	pageCount=count/5;
else
	pageCount=count/5+1;
int pageGroupCount=0;
if(pageCount%5==0)
	pageGroupCount=pageCount/5;
else
	pageGroupCount=pageCount/5+1;
int pageGroupNo=0;
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
}	
session.setAttribute("pageGroupNo", pageGroupNo);
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
ArrayList<Product> plist=pdi.getProductByCategoryByPage(name, pageNo);
session.setAttribute("plist", plist);
response.sendRedirect("search.jsp");
%>