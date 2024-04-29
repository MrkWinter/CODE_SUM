<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户名验证</title>
</head>
<body>
<h3>请输入用户名：</h3>
<form action="result.jsp" method="post">
    用户名：<input type="text" name="username" required>
    <br> 只能由字母,数字或下划线组成<br>
    <input type="submit" value="验证">
</form>
</body>
</html>


