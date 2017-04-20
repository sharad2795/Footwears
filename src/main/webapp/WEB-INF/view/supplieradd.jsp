<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUPPLIER</title>
</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>

<div class="container">
  <form:form  action="supplieradd" method="post" commandname="Supplier">
    <div class="form-group">
      <label>SUPPLIER ID:</label><label>${nullid}</label>
      <form:input type="text" class="form-control" id="id" path="id" placeholder="Enter supplierid"/><br>
      <label>SUPPLIER NAME:</label><label>${nullname}</label>
      <form:input type="text" class="form-control" id="name" path="name" placeholder="Enter suppliername"/><br>
      <label>ADDRESS:</label><label>${nulladdr}</label>
      <form:textarea type="text" class="form-control" id="address" path="address" placeholder="Enter address" rows="5"></form:textarea>
    <br><br> <center> <button type="submit" class="btn btn-success">ADD</button></center>
    </div>
    </form:form>
    </div>
 <jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>