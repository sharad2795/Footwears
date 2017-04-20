<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty pkey }">
<center>${fkey}</center>
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${not empty pkey }">
<jsp:include page="commonheader.jsp"></jsp:include>
<center>${msg1}</center>
<center>${passkey}</center>
<center>${lkey}</center>

<jsp:include page="commonfotter.jsp"></jsp:include>
</c:if>



</body>
</html>