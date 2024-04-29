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
$(document).ready(function(){
 $("#uname").blur(function()
{
	var name = $("#uname").val();			
	var info=$("#info");			
	if(name == ""){
		alert("请输入用户名");
		return false;
	}else{
		$.ajax({
			url:"checkRegister",
			type:"post",
			contentType:"application/x-www-form-urlencoded",
			data:"uname="+name,		          
            success:function(str){
					if(str==0){
					info[0].innerHTML = "用户名不存在，可以使用";								
				}else{
					info[0].innerHTML="用户名已经存在";							
				}		            		
			},
			error:function()
			{
				alert("error");					
			}				
		});
	}			
}		
);
}
);
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
					<li><a href="login.jsp">登录</a></li>
					<li><a href="register.jsp">注册</a></li>
					<li><a href="cart.jsp">购物车</a></li>
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
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>

		<!--body-->

		<div style="margin-top: 20px;">
			<form class="form-horizontal" role="form" action="DoRegister">
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="用户名"
							name="uname" id="uname" />
					</div>
					<div id="info" style="display: inline"></div>
				</div>
				<div class="form-group" style="margin-left: 200px">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" id="inputPassword3"
							placeholder="密码" name="pwd">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">姓</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="姓"
							name="firstname">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">名</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="名"
							name="lastname">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="邮箱"
							name="email">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="电话"
							name="phone">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">常用地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="常用地址"
							name="addr1">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">其他地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="其他地址"
							name="addr2">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">城市</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="城市"
							name="city">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">省份</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="省份"
							name="state">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">邮编</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="邮编"
							name="zip">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<label for="inputEmail3" class="col-sm-2 control-label">国家</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" placeholder="国家"
							name="country">
					</div>
				</div>
				<div class="form-group" style="margin-left: 200px;">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">提交</button>
					</div>
				</div>
			</form>

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
</body>
</html>
