<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<!--BootStrap设计的页面支持响应式的 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<!--引入BootStrap的CSS-->
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>


	<!--body-->


	<table class="table table-striped">
		<tr>
			<td>图书编号</td>
			<td>图书名称</td>
			<td>图书描述</td>
			<td>修改操作</td>
			<td>删除操作</td>
		</tr>
		<tr>
			<td>1001</td>
			<td>JSP</td>
			<td>JSP</td>
			<td><a class="btn btn-default" role="button" data-toggle="modal"
				data-target="#myModal2">修改</a></td>
			<td><a class="btn btn-default" role="button" data-toggle="modal"
				data-target="#myModal3">删除</a></td>
		</tr>
		<tr>
			<td>1012</td>
			<td>Java</td>
			<td>Java</td>
			<td><a class="btn btn-default" role="button" data-toggle="modal"
				data-target="#myModal2">修改</a></td>
			<td><a class="btn btn-default" role="button" data-toggle="modal"
				data-target="#myModal3">删除</a></td>
		</tr>
		<tr>
			<td>1003</td>
			<td>JAVAEE</td>
			<td>JavaEE</td>
			<td><a class="btn btn-default" role="button" data-toggle="modal"
				data-target="#myModal2">修改</a></td>
			<td><a class="btn btn-default" role="button" data-toggle="modal"
				data-target="#myModal3">删除</a></td>
		</tr>


		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><button type="button" class="btn btn-default"
					data-toggle="modal" data-target="#myModal">添加信息</button></td>
		</tr>






	</table>













</body>
</html>
