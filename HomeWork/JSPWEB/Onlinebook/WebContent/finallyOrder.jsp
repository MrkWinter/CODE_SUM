<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>

<title>checkOrderInfo</title>
<style type="text/css">

.a{
 border-collapse: collapse; 
}

#contrainer{margin:0 auto;width:900Px;}
#header{height:100px;margin-bottom:5px; background-color:#2d6eba}
#center{height:950px; margin-bottom:5px; background-color:#dadbe3}
#footer{height:80px; background-color:#2d6eba}

.red{font-size:10px; color:#F00;}
.green{font-size:10px; color:#0C6}

</style>
<%Date date=new Date();
SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss");
String time=dt.format(date);
%>

</head>

<body>
<div id="contrainer">
<%@ include file="header.jsp" %>  <!-- 页面头部信息 -->
<div id="center" align="center">


 
  
   <form action="DoFinallyOrder" method="post">
 
 <table bgcolor="#CCFFCC" width="550px" height="750px">
<tr align="center" bgcolor="#CCFFFF" height="45px"><td colspan="2">Order</td></tr>
<tr align="center"  height="35px"><td colspan="2"><%=time %></td></tr>

 <tr align="center" bgcolor="#FFFFCC" height="35px"><td colspan="2">Payment Details</td></tr>
 
 <tr><td>Card Type:</td><td>${sessionScope.fname}</td></tr>
 <tr><td>Card Number:</td><td>${sessionScope.lname}</td></tr>
 <tr><td>Expiry Date:</td><td>${sessionScope.addr1}</td></tr>

 <tr align="center" bgcolor="#FFFFCC" height="35px"><td colspan="2">Billing Address</td></tr>
 
 <tr><td>First name:</td><td>${sessionScope.fname}</td></tr>
 <tr><td>Last name:</td><td>${sessionScope.lname}</td></tr>
 <tr><td>Address1:</td><td>${sessionScope.addr1}</td></tr>
 <tr><td>Address2:</td><td>${sessionScope.addr2}</td></tr>
 <tr><td>City:</td><td>${sessionScope.city}</td></tr>
 <tr><td>State:</td><td>${sessionScope.state}</td></tr>
 <tr><td>Zip:</td><td>${sessionScope.zip}</td></tr>
 <tr><td>Country:</td><td>${sessionScope.country}</td></tr>
 
 <tr align="center" bgcolor="#FFFFCC" height="35px"><td colspan="2">Shipping Address</td></tr>
 
 <tr><td>First name:</td><td>${sessionScope.sfname}</td></tr>
 <tr><td>Last name:</td><td>${sessionScope.slname}</td></tr>
 <tr><td>Address1:</td><td>${sessionScope.saddr1}</td></tr>
 <tr><td>Address2:</td><td>${sessionScope.saddr2}</td></tr>
 <tr><td>City:</td><td>${sessionScope.scity}</td></tr>
 <tr><td>State:</td><td>${sessionScope.sstate}</td></tr>
 <tr><td>Zip:</td><td>${sessionScope.szip}</td></tr>
 <tr><td>Country:</td><td>${sessionScope.scountry}</td></tr>
 <tr><td>Courier:</td><td>${sessionScope.courier }</td></tr>
 <tr bgcolor="#FFFFCC" height="35px"><td>Status</td><td>P</td></tr>
 </table>
 
 
 <table class="a" border="2" width="550px" height="100px" bgcolor="#CCFFCC">
 <tr bgcolor="#CCFFFF"><th>项目编号</th><th>描述</th><th>购买数量</th><th>单价</th><th>总价</th></tr>
 
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 <tr><td colspan="5"></td></tr>
 
 </table>
 
 
 
 </form>
  

 
 
  
  
  

</div>
<%@ include file="footer.jsp" %> <!-- 页面底部信息 -->


</div>

</body>
</html>