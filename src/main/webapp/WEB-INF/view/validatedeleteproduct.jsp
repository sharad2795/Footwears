<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 tdansitional//EN" "http://www.w3.org/td/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>

<div class="container">                                                                                     
  <div class="table-responsive">          
  <table class="table table-bordered">
    <thead >
      <tr >
        <th style="text-align: center">PRODUCT ID</th>
        <th >PRODUCT NAME</th>
        <th>DESCRIPTION</th>
        <th>QUANTITY</th>
        <th>COST</th>
      
       
      </tr>
    </thead>
    <c:forEach var="list" items="${productlist}">
    <tbody>
      <tr>
        <td>${list.pid}</td>
        <td>${list.pname}</td>
        <td>${list.description}</td>
        <td>${list.quantity}</td>
        <td>${list.cost}</td>
       	
       
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
</div>
 
<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>