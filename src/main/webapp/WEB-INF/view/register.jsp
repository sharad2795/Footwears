<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>
<div class = "container">
	<div class="wrapper">
		<form:form action="validatereg" method="post" name="Login_Form" command="User" class="form-signin">       
		    <h3 class="form-signin-heading">REGISTER HERE </h3>
			  <hr class="colorgraph"><br>
			  <label>${nullfname}</label><label>${errormessage}</label>
			  <form:input type="text" class="form-control" name="firstname" path="firstname" placeholder="Firstname" required="" autofocus="" /><br>
			  <label>${nulllname}</label>
			  <form:input type="text" class="form-control" name="lastname" path="lastname" placeholder="Lastname" required=""  /><br>
			 <label>${nulluide}</label><label>${errormessage}</label>
			  <form:input type="text" class="form-control" name="userid" path="userid" placeholder="Userid" required="" /><br>
			  <label>${nullpass}</label><label>${fkey}</label>
			  <form:input type="password" id="passw" pattern=".{6,}" title="Six or more characters" path="password" class="form-control" name="password" placeholder="Password" required=""/><br>
			  <label>${nullcp}</label><label>${fkey}</label>
			  <form:input type="password" class="form-control" id="confirmpass" name="confirmpassword" path="confirmpassword" placeholder="confirmPassword" required=""/><br>
			  <label>${nullemail}</label>
			  <form:input type="email" class="form-control" name="emailid" path="emailid" placeholder="emailid" required=""/><br>
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="register" type="Submit">REGISTER</button>  			
		</form:form>			
	</div>
</div>
<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>