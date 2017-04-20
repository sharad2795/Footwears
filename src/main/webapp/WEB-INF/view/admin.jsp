<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN PAGE</title>

</head>
<body>
<center>
<jsp:include page="commonheader.jsp"></jsp:include>

<div class = "container">
	<div class="wrapper">
	

 <div class="col-md-4">
  <div class="col-sm-4"><a href="addproduct"class="btn btn-success">ADD A NEW PRODUCT</a></div>
  </div>
  
  <div class="col-md-4">
<div class="col-sm-7"><a href="editproduct"class="btn btn-primary">EDIT EXSISTING PRODUCT</a></div>
</div>

<div class="col-md-4">
<div class="col-sm-1"><a href="deleteproduct"class="btn btn-danger">DELETE PRODUCT</a></div>


</div>
</div>
</div>
<br>
<br>

<div class = "btn-group">
   
   <button type = "button" class = "btn btn-primary dropdown-toggle" data-toggle = "dropdown">
      CATEGORY 
      <span class = "caret"></span>
   </button>
   
   <ul class = "dropdown-menu" role = "menu">
      <li><a href = "categorycrud">ADD CATEGORY</a></li>
      <li><a href = "updatecategory">UPDATE CATEGORY</a></li>
      <li><a href = "deletecategory">DELETE CATEGORY</a></li>
      </ul>
      
 </div>
 <div class = "btn-group">
   
   <button type = "button" class = "btn btn-primary dropdown-toggle" data-toggle = "dropdown">
      SUPPLIER
      <span class = "caret"></span>
   </button>
   
   <ul class = "dropdown-menu" role = "menu">
      <li><a href = "addsupplier">ADD SUPPLIER</a></li>
      <li><a href = "supplierupdate">UPDATE SUPPLIER</a></li>
      <li><a href = "deletesupplier">DELETE SUPPLIER</a></li>
      </ul>
      
 </div>
<jsp:include page="commonfotter.jsp"></jsp:include>
 
 
 
<jsp:include page="commonfotter.jsp"></jsp:include>

</center>
</body>
</html>





