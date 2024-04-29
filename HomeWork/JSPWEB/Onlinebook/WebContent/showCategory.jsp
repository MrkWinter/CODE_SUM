<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.CategoryDaoImp" %>
<%@ page import="com.hkd.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
CategoryDaoImp cdi=new CategoryDaoImp();
ArrayList<Category> clist=cdi.getCategory();
session.setAttribute("clist", clist);

%>
<html>
	<head>
		<meta charset="UTF-8">
		<!--BootStrap设计的页面支持响应式的 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<!--引入BootStrap的CSS-->
		<link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
		<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
		<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
		<!--引入BootStrap的JS的文件-->
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		</head>
	<body>
		
			
			<!--body-->
			
			
		<table class="table table-striped">
				<tr><td>类别编号</td><td>类别名称</td><td>类别描述</td><td>修改操作</td><td>删除操作</td></tr>
				
				 <c:forEach items="${sessionScope.clist }" var="category" varStatus="c" >
	<tr>
	<td>${category.catID }</td>
	<td>${category.name }</td>
	<td>${category.descn }</td>
	<td><a class="btn btn-default" role="button" data-toggle="modal" data-target="#myModal2">修改</a></td>
	<td><a class="btn btn-default" role="button" data-toggle="modal" data-target="#myModal3">删除</a></td>
	</tr>
		</c:forEach>		
				 
				<tr><td></td><td></td><td></td><td></td><td><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">添加信息</button></td></tr>
				
				
				
				
				
  
            </table>
			
			
			
			
			
			
			
		
		
		
		
		
		
	</body>
</html>
