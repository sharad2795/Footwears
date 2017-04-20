<html>
    <head>
        <title>HI</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha256-k2/8zcNbxVIh5mnQ52A0r3a6jAgMGxFJFE2707UxGCk= sha512-ZV9KawG2Legkwp3nAlxLIVFudTauWuBpC10uEafMHYL0Sarrz5A7G79kXh5+5+woxQ5HM559XX2UZjMJ36Wplg==" crossorigin="anonymous">
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
    </head>
    <body style="font-family: 'Open Sans', sans-serif;">
	<jsp:include page="commonheader.jsp"></jsp:include>
	${SuccessU }
       <div class="container">
	<div class="row">
        <div class="col-sm-12">
            <legend>EDIT PRODUCT</legend>
        </div>
        <!-- panel preview -->
        <div class="col-sm-8" style="margin:0 auto;width:100%">
     
            <div class="panel panel-default">
                <div class="panel-body form-horizontal payment-form">
                <form:form action="validateeditproduct" method="post" commandname="productmodel" enctype="multipart/form-data">
                <div class="form-group">
                        <label for="concept" class="col-sm-3 control-label">PRODUCTID</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="pid" name="pid" value="${PID }"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="concept" class="col-sm-3 control-label">PRODUCTNAME</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="pname" name="pname" value="${PNAME }"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="concept" class="col-sm-3 control-label">PRODUCTIMAGE</label>
                        <div class="col-sm-9">
                            <form:input type="file" class="form-control" path="productimage" name="productimage" value="${PIMAGE }"/>
                        </div>
                    </div>
                       <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">DESCRIPTION</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="description" name="description" value="${DESC}"/>
                        </div>
                    </div>
                 <div class="form-group">
                        <label for="quantity" class="col-sm-3 control-label">QUANTITY</label>
                        <div class="col-sm-9">
                            <form:input type="number" class="form-control" path="quantity" name="quantity" value="${QTY}"/>
                        </div>
                    </div>   
                     <div class="form-group">
                        <label for="costprice" class="col-sm-3 control-label">COSTPRICE</label>
                        <div class="col-sm-9">
                            <form:input type="number" class="form-control" path="cost" name="cost" value="${CP}"/>
                        </div>
                    </div>   
                    
             </div>
            </div>            
        </div> 
            <div class="row">
                <div class="col-xs-12">
                    <hr style="border:1px dashed #dddddd;">
                    <input type="submit" value="Update" class="btn btn-primary btn-block">
                </div>                
            </div>
      </form:form>
        </div>
	</div>
</div>
        <jsp:include page="commonfotter.jsp"></jsp:include>
    </body>
</html>