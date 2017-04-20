<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>SHOE FACTORY LOGIN</title>
</head>
<body>

<jsp:include page="commonheader.jsp"></jsp:include>
<div class = "container">
	<div class="wrapper">
		<form:form action="j_spring_security_check" name="Login_Form" class="form-signin" method="post" commandname="User">       
		    <h3>WELCOME TO LOGIN</h3>
			  <hr><br>
			  
			  <form:input type="text" class="form-control" id="userid" name="userid" path="userid" placeholder="Userid" required="" autofocus="" /><br>
			  <form:input type="password" class="form-control" id="password" name="password" path="password" placeholder="Password" required=""/><br>
			 <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			  <button class="btn  btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form:form>			
	</div>
</div>
<jsp:include page="commonfotter.jsp"></jsp:include>

</body>
</html>