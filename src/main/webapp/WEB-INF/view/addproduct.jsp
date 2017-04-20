<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="commonheader.jsp"></jsp:include>


<div class = "container">
	<div class="wrapper">
	<div class="col-md-12">
	<form:form action="validateaddproduct" method="post" commandname="productmodel" enctype="multipart/form-data"> 
	<div class="form-group">
	 <div class="col-sm-3"><form:input type="text" path="pid" class="form-control" name="PRODUCT ID" placeholder="Productid" required=""  /></div>
	 <div class="col-sm-3"><label>${idnull}</label></div>
	<div class="col-sm-3"><form:input type="text" path="pname" class="form-control" name="PRODUCTNAME" placeholder="productname" required="" /></div><br>
	 <div class="col-sm-3"><label>${namenull}</label></div>
	</div>
	<br>
	<div class="form-group">
	<div class="col-sm-6"><label>${qtynull}</label><form:input type="text" path="quantity" class="form-control" name="PRODUCT QUANTITY" placeholder="Producquantity" required="" /></div>
	<div class="col-sm-6"><label>${costnull}</label><form:input type="text" path="cost" class="form-control" name="PRODUCT COST" placeholder="productcost" required="" /></div><br>
	</div>
	<br>
	
	
	<div class="form-group row">
	<div class="col-sm-12">
	<select name="categoryname" class="form-control form-control-lg">
	<c:forEach var="list" items="${categorylist}">
    <option value="${list.name}">${list.name}</option>
    </c:forEach>
  </select>
  </div>
  </div><br>
  
  <div class="form-group row">
	<div class="col-sm-12">
	<select name="suppliername" class="form-control form-control-lg">
	<c:forEach var="list" items="${supplierlist}">
    <option value="${list.name}">${list.name }</option>
    </c:forEach>
  </select>
  </div>
  </div><br>
	
	
	
	
	<div class="form-group">
	<div class="col-sm-12">
	<form:input type="file" path="productimage" class="form-control" placeholder="upload image"/>
	</div>
	</div>
	<br>
	<br>
	
	<div class="form-group row">
	<div class="col-sm-12">
	<label>${descnull}</label><form:textarea type="text" path="description" class="form-control form-control-lg" name="PRODUCT DESCRIPTION" placeholder="Product description" rows="5" required="" ></form:textarea></div>
	</div>
	<br>
	<br>
	
	
	
	<button class="btn  btn-primary btn-block"  name="Submit" value="ADDPRODUCT" type="Submit">ADDPRODUCT</button>  			
		</form:form>
		</div>
		</div>
		</div>
<jsp:include page="commonfotter.jsp"></jsp:include>
</body>
</html>