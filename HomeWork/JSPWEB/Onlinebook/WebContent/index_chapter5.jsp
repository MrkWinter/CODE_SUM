<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.CategoryDaoImp"%>
<%@ page import="com.hkd.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
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
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
#logo ul li {
	list-style: none;
	float: left;
	padding: 5px 10px;
	line-height: 60px;
}
</style>

</head>
<%
	CategoryDaoImp cdi=new CategoryDaoImp();
	ArrayList<Category> clist=cdi.getCategory();	
	%>
<body>
	<div class="container">
		<!--logo-->
		<div class="row">
			<div class="col-md-4">
				<h3>在线图书销售平台</h3>
			</div>
			<div class="col-md-4">
				<img src="img/header.jpg" />
			</div>
			<div class="col-md-4" id="logo">
				<ul>
					<li><a href="register.jsp">登录</a></li>
					<li><a href="register.jsp">注册</a></li>
					<li><a href="cart.jsp">购物车</a></li>
				</ul>
			</div>
		</div>
		<!--导航-->
		<div id="">
			<nav class="navbar navbar-inverse" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">首页</a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<%
      int i=0;
      for(Category category:clist)
      {
    	  i++;
    	 if(i<=5)
    	 {
      %>
					<li><a
						href="product_chapter5.jsp?category=<%=category.getCatID()%>"><%=category.getName() %></a></li>
					<%
    	 }
      }
      %>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">其他 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<%
      int j=0;
      for(Category category:clist)
      {
    	  j++;
    	  if(j>=6)
    	  {
      %>
							<li><a
								href="product_chapter5.jsp?category=<%=category.getCatID()%>"><%=category.getName() %></a></li>
							<%
    	  }
      }
      %>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right" role="search"
					action="DoProduct3">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="pname">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			</nav>
		</div>
		<!--页面主题-->
		<div class="row">
			<!--类别列表-->
			<div class="col-md-4">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#">当前流行</a></li>
					<%
      int k=0;
      for(Category category:clist)
      {
    	  k++;
    	  if(k<=5)
    	  {
      %>
					<li><a
						href="product_chapter5.jsp?category=<%=category.getCatID()%>"><%=category.getName() %></a></li>
					<%
    	  }
      }
      %>
				</ul>
			</div>
			<!--轮播图-->
			<div class="col-md-8">
				<div id="">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="img/12.jpg" alt="...">
								<div class="carousel-caption">第一张图片</div>
							</div>

							<div class="item ">
								<img src="img/12.jpg" alt="...">
								<div class="carousel-caption">第二张图片</div>
							</div>

							<div class="item">
								<img src="img/12.jpg" alt="...">
								<div class="carousel-caption">第三张图片</div>
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
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
