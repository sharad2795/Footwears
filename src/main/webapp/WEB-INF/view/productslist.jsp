<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 tdansitional//EN" "http://www.w3.org/td/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>
<CENTER><h2>AVAILABLE PRODUCTS</h2></CENTER>
<div class="row">
 <c:forEach items="${productlist}" var="list">
    <div class="col-xs-6 col-md-3">
      <div class="thumbnail">
        <img src="images/${list.pid}.jpg" height="75">
          <div class="caption">
          <center>${list.pname}
          <p>Cost: ${list.cost}</p>
          <a href="addtocart?pid=${list.pid }" class= "btn btn-info btn-sm">ADD TO CART</a>		
          </center>
          </div>
          </div>
    </div>
    </c:forEach>
    </div>

<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>