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
        <th style="text-align: center">SUPPLIER ID</th>
        <th >SUPPLIER NAME</th>
        <th>ADDRESS</th>
      </tr>
    </thead>
    <c:forEach var="list" items="${updatelist}">
    <tbody>
      <tr>
        <td>${list.id}</td>
        <td>${list.name}</td>
        <td>${list.address}</td>
    </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
</div>
<center>
 <form:form class="form-inline" action="validateupdatesupplier" commandname="Supplier">
   <div class="form-group " >
 
 
    <form:input type="text" class="form-control" placeholder="ENTERTHESUPPLIERID" name="id" path="id"/>
           			<label>${nullid}</label>	  <button type="submit" class="btn btn-success ">EDIT</button>
 
 </div>
 
  </form:form>
  </center>

<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>