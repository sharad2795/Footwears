<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>
<div class="container">                                                                                     
  <div class="table-responsive">          
  <table class="table table-bordered">
    <thead >
      <tr >
        <th style="text-align: center">CART ID</th>
        <th> PRODUCT NAME</th>
        <th>IMAGE</th>
        <th>PRICE</th>
        <th>STATUS</th>
       <th> DATE ADDED</th>
       <th> QUANTITY</th>
       <th> SUM</th>
      </tr>
    </thead>
  <c:forEach var="list" items="${showcartlist}">
  <tbody>
  <tr>
  	<td>${list.id }</td>
  	<td>${list.productname}</td>
  	<td><img src="images/${list.product_id}.jpg" height="75">
  	<td>${list.price}</td>
  	<td>${list.status}</td>
  	<td>${list.date_added}</td>
  	<td><a href="increaseqty?id=${list.id}"><button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span></button></a>&nbsp;${list.quantity}&nbsp;<a href="decreaseqty?id=${list.id}"><button type="submit" class="btn btn-default" style="color:#FF3349;"><span class="glyphicon glyphicon-minus"></span></button></a></td>
  	<td>${list.sum}</td>
  	<td><a href="deletecart?id=${list.id}"><button type="submit" class="btn btn-default" style="color:#FF3349;"><span class="glyphicon glyphicon-remove"></span></button></a></td>
  	</tr>
  	</tbody>
  </c:forEach>
  <tr>
  	<td colspan="6" Style="text-align:right">Total</td>
  	<td>${carttotal}</td>
  	</tr>
  	
  </table>
  <c:if test="${carttotal!=0}">
  <a href="checkout" class="btn btn-primary">CHECKOUT</a>
  </c:if>
  </div>
  </div>
  <jsp:include page="commonfotter.jsp"></jsp:include>
  </body>
</html>