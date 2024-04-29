<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>

<title>order</title>
<style type="text/css">

.a{
 border-collapse: collapse; 
}

#contrainer{margin:0 auto;width:900Px;}
#header{height:100px;margin-bottom:5px; background-color:#2d6eba}
#center{height:650px; margin-bottom:5px; background-color:#dadbe3}
#footer{height:80px; background-color:#2d6eba}

.red{font-size:10px; color:#F00;}
.green{font-size:10px; color:#0C6}

</style>

</head>

<body>
<div id="contrainer">
<%@ include file="header.jsp" %>  <!-- 页面头部信息 -->
<div id="center" align="center">


  
  
  
 <form action="DoOrder" method="post">
 
 <table class="a" border="2" bgcolor="#CCFFCC" width="350px" height="500px">
 <tr align="center" bgcolor="#FFFFCC"  height="35px"><td colspan="2">Payment Details</td></tr>
 
 <tr><td >Card Type:</td><td><select name="cardty" id="cardty"><option>建设银行</option><option>工商银行</option><option>农业银行</option></select></td></tr>
 <tr><td>Card Number:</td><td><input type="text" id="cardnum" name="cardnum" size="20" /></td></tr>
 <tr><td>Expiry Date(MM/YYYY):</td><td><input type="text" id="exdate" name="exdate" size="20" /></td></tr>
 
 <tr align="center" bgcolor="#FFFFCC" height="35px"><td colspan="2">Billing Address</td></tr>
 
 <tr><td>First name:</td><td><input type="text" id="fname" name="fname" size="20" value="${sessionScope.fname }" /></td></tr>
 <tr><td>Last name:</td><td><input type="text" id="lname" name="lname" size="20" value="${sessionScope.lname }"/></td></tr>
 <tr><td>Address1:</td><td><input type="text" id="addr1" name="addr1" size="20" value="${sessionScope.addr1 }"/></td></tr>
 <tr><td>Address2:</td><td><input type="text" id="addr2" name="addr2" size="20" value="${sessionScope.addr2 }"/></td></tr>
 <tr><td>City:</td><td><input type="text" id="city" name="city" size="20" value="${sessionScope.city }"/></td></tr>
 <tr><td>State:</td><td><input type="text" id="state" name="state" size="20" value="${sessionScope.state }"/></td></tr>
 <tr><td>Zip:</td><td><input type="text" id="zip" name="zip" size="20" value="${sessionScope.zip }"/></td></tr>
 <tr><td>Country:</td><td><input type="text" id="country" name="country" size="20" value="${sessionScope.country }"/></td></tr>
 
 
 </table>
 <br/>
 <table  align="right" width="400px">
 <tr><td><input type="submit" id="sub" name="sub" value=" 提      交   "></tr></td>
 
 </table>
 
 
 
 
 </form>
 
 
  
  
  

</div>
<%@ include file="footer.jsp" %> <!-- 页面底部信息 -->


</div>
</div>
</body>
</html>