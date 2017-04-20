<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <th style="text-align: center">category ID</th>
        <th >CATEGORY NAME</th>
        <th>DESCRIPTION</th>
      </tr>
    </thead>
    <c:forEach var="list" items="${categorylist}">
    <tbody>
      <tr>
        <td>${list.id}</td>
        <td>${list.name}</td>
        <td>${list.description}</td>
    </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
  <center><a href="categorycrud"class="btn btn-info btn-lg">ADD ANOTHER CATEGORY</a></center>
</div>
<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>