<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hkd.daoimp.SignonDaoImp"%>
<%@ page import="com.hkd.entity.Signon"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	SignonDaoImp sdi = new SignonDaoImp();
	ArrayList<Signon> slist = sdi.getAllSignon();
	session.setAttribute("slist", slist);
%>
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
<script type="text/javascript">
	function showUpdate(name, pass) {
		//alert(name);
		var uname = document.getElementById("updateuname1");
		var pwd = document.getElementById("updatepwd1");
		uname.value = name;
		//$(updateuname).value="1111";
		pwd.value = pass;

	}
	function showDelete(name, pass) {
		//alert(name);
		var uname = document.getElementById("deleteuname");
		var pwd = document.getElementById("deletepwd");
		uname.value = name;
		//$(updateuname).value="1111";
		pwd.value = pass;

	}

	function insert() {

		var uname = document.getElementById("insertuname").value;
		var pwd = document.getElementById("insertpwd").value;

		$.ajax({
			url : "InsertSignon?uname=" + uname + "&pwd=" + pwd,
			type : "get",

			success : function(data) {
				if (data == 1) {

					alert("插入成功");
					window.location.href = "showSignon.jsp";
				} else if (data == "2") {

					alert("插入失败");
					window.location.href = "showSignon.jsp";
				}

			},
			error : function() {
				alert("error");
			}

		});

	}
	function update() {

		var uname = document.getElementById("updateuname1").value;
		var pwd = document.getElementById("updatepwd1").value;

		$.ajax({
			url : "UpdateSignon?uname=" + uname + "&pwd=" + pwd,
			type : "get",

			success : function(data) {
				if (data == 1) {

					alert("修改成功");
					window.location.href = "showSignon.jsp";
				} else if (data == "2") {

					alert("修改失败");
					window.location.href = "showSignon.jsp";
				}

			},
			error : function() {
				alert("error");
			}

		});

	}

	function deleteUser() {

		var uname = document.getElementById("deleteuname").value;

		$.ajax({
			url : "DeleteSignon?uname=" + uname,
			type : "get",

			success : function(data) {
				if (data == 1) {

					alert("删除成功");
					window.location.href = "showSignon.jsp";
				} else if (data == "2") {
					alert("删除失败");
					window.location.href = "showSignon.jsp";
				}

			},
			error : function() {
				alert("error");
			}

		});
	}
</script>



<body>


	<!--body-->


	<table class="table table-striped">
		<tr>
			<td>用户名</td>
			<td>密码</td>
			<td>修改操作</td>
			<td>删除操作</td>
		</tr>

		<c:forEach items="${sessionScope.slist }" var="signon" varStatus="s">
			<tr>
				<td>${signon.userName }</td>
				<td>${signon.password }</td>
				<td><button type="button" class="btn btn-default"
						data-toggle="modal" data-target="#myModal2"
						onclick="showUpdate('${signon.userName }','${signon.password }')">修改</button></td>
				<td><a class="btn btn-default" role="button"
					data-toggle="modal" data-target="#myModal3"
					onclick="showDelete('${signon.userName }','${signon.password }')">删除</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><button type="button" class="btn btn-default"
					data-toggle="modal" data-target="#myModal">添加信息</button></td>
		</tr>






	</table>









	<!-- 对话框 1-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">增加用户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="insertuname"
									name="uname">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="insertpwd"
									name="pwd">
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="insert()">添加</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- 对话框2-->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="updateuname1"
									name="uname" readonly />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="updatepwd1"
									name="pwd" />
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="update()">修改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- 对话框3-->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">删除用户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="deleteuname"
									name="uname" readonly />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="deletepwd"
									name="pwd" readonly />
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="deleteUser()">删除</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



</body>
</html>
