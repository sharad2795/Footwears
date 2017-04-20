<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>validate login </title>
</head>
<body>
<c:if test="${not empty lkey }">
<jsp:include page="commonheader.jsp"></jsp:include>
<jsp:include page="commonfotter.jsp"></jsp:include>
<center>${lkey }</center>
</c:if>
<c:if test="${empty lkey }">
<center>${fail}</center>
<jsp:include page="login.jsp"></jsp:include>
</c:if>

</body>
</html>