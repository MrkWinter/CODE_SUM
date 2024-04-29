<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>

<title>cart</title>
<style type="text/css">
.a{
 border-collapse: collapse; 
}
#contrainer{margin:0 auto;width:900Px;}
#header{height:100px;margin-bottom:5px; background-color:#2d6eba}
#center{height:400px; margin-bottom:5px;background-color:#dadbe3 }
#footer{height:80px; background-color:#2d6eba}

</style>
</head>

<body>
<div id="contrainer">
<%-- <%@ include file="header.jsp" %> --%>
<div id="center" align="center">
<a href="Item.jsp"><table align="left" width="120" height="35" bgcolor="#FFFFCC">
<tr><td align="center"><font size="3"><< return</td></tr>
</table></a>
  
  
  <br/><br/><br/><br/>
  
  <form action="DoUpdateCart"  method="post">
  
   <table  class="a" border="2" width="750px"   >
  <tr bgcolor="#FFFFCC" height="35px"><th >项目编号</th><th>产品编号</th>
  <th >描述</th><th >库存</th>
  <th>数量</th>
  <th >单价</th>
  <th >总价</th>
   <th >操作</th></tr>
  <%int i=0; %>
  <c:forEach var="cart" items="${sessionScope.cartlist}" varStatus="status">
  <tr  bgcolor="#CCFFCC"  height="30px">
  <td> ${cart.itemid} </a></td>
  
  <td >${cart.productid}</td>
   <td>${cart.attr1} ${cart.name}</td>
    <td >${cart.qty}</td>
    <td ><input type="text" name="qty<%=i %>" id="qty" value="${cart.buyqty}" size="6"/></td>
     <td >${cart.listprice}</td>
      <td >${cart.listprice*cart.buyqty}</td>
      
      <td > <a href="DoRemoveCart?itemid=${cart.itemid}">remove </a></td> 
  </tr>
  
  <%i++; %>
  </c:forEach>
  
  <tr bgcolor="#CCFFCC"  height="30px">  <td colspan="7" align="right"> Total:${sessionScope.total } </td>
  <td> <input type="submit" name="btn" value="update cart"/></td></tr>
  </table>
  </form>
  
<br/><br/>
  <table align="center"><tr><td> <a href="checkCartInfo.jsp">check cart</a></td></tr></table>
 
  
  
  

</div>
<%-- <%@ include file="" %> --%> <!-- 页面底部信息 -->



</div>
</body>
</html>