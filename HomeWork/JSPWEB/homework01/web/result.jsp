<%@ page import="java.util.regex.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户名验证结果</title>
</head>
<body>
<h3>用户名验证结果：</h3>
<%
    String username = request.getParameter("username");
    String result = "";
    boolean isTrue = false;

    if (username != null && !username.isEmpty()) {
        if (Pattern.matches("[a-zA-Z][a-zA-Z0-9_]*", username)) {
            result = "用户格式正确！";
            isTrue = true;
        } else if (!Pattern.matches("[a-zA-Z0-9_]*", username)) {
            result = "用户姓名错误，只能由字母、数字和下划线组成！";
        } else {
            result = "用户姓名错误，首字符必须为字母！";
        }
    } else {
        result = "用户名不能为空！";
    }
%>
<p><strong>输入用户名为：</strong> <%= username %>
</p>
<p><strong>是否有效：</strong> <%= isTrue %>
</p>
<p><strong>提示信息：</strong> <%= result %>
</p>
<p><a href="index.jsp">返回</a></p>
</body>
</html>
