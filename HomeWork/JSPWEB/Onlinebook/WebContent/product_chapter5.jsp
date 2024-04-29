<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.ProductDaoImp"%>
<%@ page import="com.hkd.entity.Product"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="product" class="com.hkd.entity.Product" />
<jsp:setProperty property="category" name="product" />
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
<style>
#logo ul li {
	list-style: none;
	float: left;
	padding: 5px 10px;
	/*margin-top: 15px;*/
	line-height: 60px;
}
</style>
</head>
<body>
	<%
	ProductDaoImp pdi=new ProductDaoImp();
	ArrayList<Product> plist=pdi.getProductByCategory(product.getCategory());	
	%>
	<div class="container">
		<!--logo-->
		<div id="logo" class="row">
			<div class="col-md-4">
				<h2>在线图书销售平台</h2>
			</div>
			<div class="col-md-4">
				<img src="img/header.png" />
			</div>
			<div class="col-md-4">
				<ul>
					<li><a href="">登录</a></li>
					<li><a href="">注册</a></li>
					<li><a href="">购物车</a></li>
				</ul>
			</div>
		</div>
		<!--导航-->
		<div>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.jsp">首页</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>

					</div>
				</div>
			</nav>
		</div>
		<!--body-->
		<div class="row" style="height: 300px; text-align: center;">
			<div class="col-md-10 col-md-push-1">
				<table class="table table-striped">
					<tr>
						<td>图书编号</td>
						<td>图书名称</td>
						<td>图书描述</td>
					</tr>
					<%
				 for(Product p:plist)
				 {
				 %>
					<tr>
						<td><%=p.getProductID() %></td>
						<td><%=p.getName() %></td>
						<td><%=p.getDescn() %></td>
					</tr>

					<%
				 }
	%>
				</table>
			</div>
		</div>
		<!--bottom-->
		<!--版权部分-->
		<div>
			<div align="center" style="margin-top: 20px;">
				<img src="img/footer.jpg" width="100%">
			</div>
			<div>
				<!--友情链接-->
				<%@ include file="footer.jsp"%>
				<!-- 页面底部信息 -->
			</div>
		</div>
	</div>
</body>
</html>
