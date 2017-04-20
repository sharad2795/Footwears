<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse bg-primary">
  <div class="container-fluid">
    <div class="navbar-header">
     
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home"><span class="glyphicon glyphicon-home"></span> SHOEFACTORY</a></li>
       <li><a href="aboutus"><span class="glyphicon glyphicon-comment"></span>   ABOUTUS</a></li>
      <li><a href="contactus2"><span class="glyphicon glyphicon-earphone"></span>  CONTACTUS</a></li>
       <c:if test="${empty admin}">
      <li><a href="viewproducts">PRODUCTS</a></li>
      </c:if>
      <c:if test="${not empty admin}">
      <li><a href="admin">ADMIN</a></li>
      </c:if>
     </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty lkey}">
     <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     </c:if>
     <c:if test="${(not empty lkey)and (not empty pkey)}"> 
     <label>${lkey}</label>
     <li><a href="viewupdateanddeleteuser">MY ACCOUNT</a></li>   
     <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>LOGOUT</a></li>
     </c:if>

      
     <c:if test="${(empty admin)and (not empty lkey)}">
     <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span>MY CART</a><li>
     
     </c:if>
     
     <c:if test="${empty pkey }">
       <li><a href="register"><span class="glyphicon glyphicon-user"></span> REGISTER</a></li>
       </c:if></ul>
      
     
     
     
     
  </div>
</nav>
 

</body>
</html>