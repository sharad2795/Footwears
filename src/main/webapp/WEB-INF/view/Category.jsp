<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>

<div class="container">
<div class="wrapper">


  <form:form  action="category" method="post" commandname="Category">
  
    <div class="form-group">
    
      <label>CATEGORY ID:</label><label>${nullid}</label>
      <form:input type="text" class="form-control" id="id" path="id" placeholder="Enter categoryid"/><br><br>
     
      <label>CATEGORY NAME:</label><label>${nullname}</label>
      <form:input type="text" class="form-control" id="name" path="name" placeholder="Enter categoryname"/><br><br>
     
      <label>description:</label><label>${nulldesc}</label>
      <form:textarea type="text" class="form-control" id="desc" path="description" placeholder="Enter description" rows="5" ></form:textarea>
      <br><br><center><button type="submit" class="btn btn-success">ADD</button></center>
      </div>
    </form:form>
    </div>
    </div>
 <jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>