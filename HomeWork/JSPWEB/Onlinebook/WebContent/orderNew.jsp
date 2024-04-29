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
<script type="text/javascript">
	function check() {
		/* $(".qty").each(function(index,e)
		{
			alert(e.value);
			
			
		}		
		
		
		) */
	}
</script>


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
					<li>
						<%
							if (session.getAttribute("user") != null) {
								String uname = (String) session.getAttribute("user");
								out.print("欢迎" + uname);
								out.print("<a href='DoInvalidate'>注销</a>");
							} else {
								out.print("<a href='login.jsp'>登录</a>");
							}
						%>





					</li>
					<li><a href="register.jsp">注册</a></li>
					<li><a href="cart.jsp">购物车</a></li>
				</ul>
			</div>
		</div>
		<!--导航 2021-1-19-start-->
		<div id="">
			<nav class="navbar navbar-inverse" role="navigation">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp">首页</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<!--  <li class="active"><a href="#">科学</a></li>
      <li><a href="#">文学</a></li>
      <li><a href="#">动漫</a></li>
      <li><a href="#">计算机</a></li> -->
						<c:forEach items="${sessionScope.slist }" var="category"
							varStatus="s">
							<c:if test="${s.index<=4 }">
								<li><a href="DoProduct2?cid=${category.catID }">${category.name}</a></li>
							</c:if>
						</c:forEach>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">其他 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<!--  <li><a href="#">数据库</a></li>
          <li><a href="#">Java</a></li>
          <li><a href="#">概率论</a></li>
          <li class="divider"></li>
          <li><a href="#">新概念</a></li>
          <li class="divider"></li>
          <li><a href="#">大数据</a></li> -->
								<c:forEach items="${sessionScope.slist }" var="category"
									varStatus="s">
									<c:if test="${s.index>=5 }">
										<li><a href="#">${category.name}</a></li>
									</c:if>
								</c:forEach>



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
				<!-- /.navbar-collapse -->
			</nav>

		</div>
		<!--导航 2021-1-19-end-->

		<!--body-->

		<%-- <div class="row" style="height: 500px;text-align: center;">
				<div class="col-md-10 col-md-push-1">
		 <form action="DoUpdateCart1"  method="post">
  
   <table class="table table-striped">
  <tr  height="35px"><th >项目编号</th><th>产品编号</th>
  <th >描述</th><th >库存</th>
  <th>数量</th>
  <th >单价</th>
  <th >总价</th>
   <th >操作</th></tr>
  <%int i=0; %>
  <c:forEach var="cart" items="${sessionScope.cartlist}" varStatus="status">
  <tr    height="30px">
  <td> ${cart.itemid} </td>
  
  <td >${cart.productid}</td>
   <td>${cart.attr1} ${cart.name}</td>
    <td >${cart.qty}</td>
    <td ><input type="text" name="qty" class="qty" value="${cart.buyqty}" size="6" onblur="check()"/></td>
     <td >${cart.listprice}</td>
      <td >${cart.listprice*cart.buyqty}</td>
      
      <td > <a href="DoRemoveCart1?itemid=${cart.itemid}">remove </a></td> 
  </tr>
  
  <%i++; %>
  </c:forEach>
  
  <tr bgcolor="#CCFFCC"  height="30px">  <td colspan="7" align="right"> Total:${sessionScope.total } </td>
  <td> <input type="submit" name="btn" value="update cart"/></td></tr>
  </table>
  <div align="center"><a href="DoCheckLogin">continue</a></div>
  </form>

				</div>
				
			</div> --%>
		<div class="row" style="height: 500px; text-align: center;">
			<div class="col-md-10 col-md-push-1">

				<form class="form-horizontal" role="form" action="DoOrder"
					method="post">
					<table class="table table-bordered table-condensed">
						<tr align="center" bgcolor="#FFFFCC" height="35px">
							<td colspan="2">Payment Details</td>
						</tr>

						<tr>
							<td>选择银行:</td>
							<td><select name="cardty" id="cardty"><option>建设银行</option>
									<option>工商银行</option>
									<option>农业银行</option></select></td>
						</tr>
						<tr>
							<td>银行卡号:</td>
							<td><input type="text" id="cardnum" name="cardnum" size="20" /></td>
						</tr>
						<tr>
							<td>有效日期(MM/YYYY):</td>
							<td><input type="text" id="exdate" name="exdate" size="20" /></td>
						</tr>

						<tr align="center" bgcolor="#FFFFCC" height="35px">
							<td colspan="2">Billing Address</td>
						</tr>

						<tr>
							<td>姓:</td>
							<td><input type="text" id="fname" name="fname" size="20"
								value="${sessionScope.fname }" /></td>
						</tr>
						<tr>
							<td>名:</td>
							<td><input type="text" id="lname" name="lname" size="20"
								value="${sessionScope.lname }" /></td>
						</tr>
						<tr>
							<td>地址1:</td>
							<td><input type="text" id="addr1" name="addr1" size="20"
								value="${sessionScope.addr1 }" /></td>
						</tr>
						<tr>
							<td>地址2:</td>
							<td><input type="text" id="addr2" name="addr2" size="20"
								value="${sessionScope.addr2 }" /></td>
						</tr>
						<tr>
							<td>城市:</td>
							<td><input type="text" id="city" name="city" size="20"
								value="${sessionScope.city }" /></td>
						</tr>
						<tr>
							<td>省份:</td>
							<td><input type="text" id="state" name="state" size="20"
								value="${sessionScope.state }" /></td>
						</tr>
						<tr>
							<td>邮编:</td>
							<td><input type="text" id="zip" name="zip" size="20"
								value="${sessionScope.zip }" /></td>
						</tr>
						<tr>
							<td>国家:</td>
							<td><input type="text" id="country" name="country" size="20"
								value="${sessionScope.country }" /></td>
						</tr>
					</table>
					<br />
					<table class="table table-striped">
						<tr>
							<td><input type="submit" id="sub" name="sub"
								value=" 提      交   "></td>
						</tr>

					</table>




				</form>

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
