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
        <th style="text-align: center">FIRSTNAME</th>
        <th >LASTNAME</th>
        <th>USERID</th>
		<th >EMAILID</th>
		<th >ACTION</th>
      </tr>
    </thead>
    
    <tbody>
      <tr>
        <td>${updatelist.firstname}</td>
        <td>${updatelist.lastname}</td>
        <td>${updatelist.userid}</td>
        <td>${updatelist.emailid}</td>
        <td><a href="edituser"><button type="submit" class="btn btn-success ">EDIT</button></a><a href="deleteuser"><button type="submit" class="btn btn-danger ">DELETE</button></a></td>
       
    </tr>
    </tbody>    
  </table>
  </div>
  <c:if test="${userclickededit==true}">
  <center>
   <div class="container">
  <form:form class="form-inline" action="updateuser" method="post">
    <div class="form-group">
    <label>USERID:</label>
      <form:input type="text" class="form-control" id="fname" path="userid" value="${updatelist.userid}" placeholder="Enter your new firstname"/>
     	 <label>FIRSTNAME:</label>
      <form:input type="text" class="form-control" id="fname" path="firstname" value="${updatelist.firstname}" placeholder="Enter your new firstname"/>
      <label>LASTNAME:</label>
      <form:input type="text" class="form-control" id="lname" path="lastname" value="${updatelist.lastname}" placeholder="Enter your new lastname"/>
      <br><label>EMAILID</label>
      <form:input type="text" class="form-control" id="eid" path="emailid" value="${updatelist.emailid}" placeholder="Enter new emailid"/>
       <label>PASSWORD</label>
      <form:input type="password" class="form-control" id="password" path="password" value="${updatelist.password}" placeholder="Enter new password"/>
      <label>CONFIRM PASSWORD</label>
      <form:input type="password" class="form-control" id="confirmpassword" path="confirmpassword" value="${updatelist.confirmpassword}" placeholder="Enter confirmpassword"/>
     <br>
     <br>
     
      <button type="submit" class="btn btn-success">UPDATE</button>
    </div>
    </form:form>
    </div>
   
   
   
   </center>
  </c:if>
  
</div>
<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>