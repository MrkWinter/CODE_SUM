<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">科学 <span class="sr-only">(current)</span></a></li>
							<li><a href="#">文学</a></li>
							<li><a href="#">动漫</a></li>
							<li><a href="#">计算机</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">其他 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">装修</a></li>
									<li><a href="#">饮食</a></li>
									<li><a href="#">科幻</a></li>
									<li><a href="#">青春</a></li>

									<li><a href="#">怀旧</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-right">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>

		<!--body-->

		<div class="row" style="height: 500px; text-align: center;">
			<div class="col-md-10 col-md-push-1">
				<table class="table table-striped">
					<tr>
						<td>图书编号</td>
						<td>图书名称</td>
						<td>图书描述</td>
					</tr>

					<c:forEach items="${sessionScope.plist }" var="product"
						varStatus="s">
						<tr>
							<td>${product.productID }</td>
							<td>${product.name }</td>
							<td>${product.descn }</td>
						</tr>

					</c:forEach>







				</table>
				<!-- <ul class="pager">
  <li><a href="#">上一页</a></li>
  <li><a href="#">下一页</a></li>
</ul>-->

				<!--   <ul class="pagination">
  <li><a href="#">&laquo;</a></li>
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">&raquo;</a></li>
</ul> -->
				<ul class="pager">
					<li><a href="DoProduct?flag=down">前一页</a></li>
					<li><a href="DoProduct?flag=up">后一页</a></li>
				</ul>

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
				<div align="center">
					<a href="">关于我们</a> <a href="">联系我们</a> <a href="">招贤纳士</a> <a
						href="">法律声明</a> <a href="link.html">友情链接</a> <a href="">支付方式</a>
					<a href="">配送方式</a> <a href="">服务声明</a> <a href="">广告声明</a> <br />
					@ 2005-2016 科大商城 版权所有 Copyright
				</div>


			</div>


		</div>
</body>
</html>
