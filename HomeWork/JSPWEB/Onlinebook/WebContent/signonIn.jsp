<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check() {
		var uname = document.getElementById("uname").value;
		var pwd = document.getElementById("pwd").value;
		//alert(uname+";"+pwd);
		//调用AJax函数
		doAjax(uname, pwd);
	}
	var XMLHttp;
	//创建XMLHttpRequest
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) {
			XMLHttp = new XMLHttpRequest();
		} else if (window.ActiveObject) {
			XMLHttp = new ActiveObject("Microsoft.XMLHTTP");
		}
	}

	function doAjax(username, password) {
		//1.创建XMLHttpRequest对象
		createXMLHttpRequest();

		if (XMLHttp != null) {
			//alert(1);
			//2.发送请求
			XMLHttp.open("GET", "DoSignon?uname=" + username + "&pwd="
					+ password, true);
			//3.设置请求表头
			XMLHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;");
			//4.指定回调函数
			XMLHttp.onreadystatechange = processRequest;
			//5.调用send
			XMLHttp.send(null);
		} else {
			alert("不能创建XMLHttpRequest对象实例");
		}
	}
	String.prototype.trim = function() {
		var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
		return (m == null) ? "" : m[1];
	}
	//编写回调函数
	function processRequest() {
		if (XMLHttp.readyState == 4) {
			//alert(2);
			if (XMLHttp.status == 200) {
				var infoDiv = document.getElementById("info");
				var str = XMLHttp.responseText;
				alert(str);
				if (str == 1) {
					infoDiv.innerHTML = "输入正确";
				} else if (str == 2) {
					infoDiv.innerHTML = "输入错误";
				}
			}
		}
	}
</script>


<body>
	<form>
		用户名:<input type="text" name="uname" id="uname" /><br /> 密码:<input
			type="text" name="pwd" id="pwd" />
		<div id="info"></div>
		<input type="button" name="btn" value="提交" onclick="check()" />

	</form>
</body>
</html>