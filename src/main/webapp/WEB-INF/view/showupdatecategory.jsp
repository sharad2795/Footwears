<html>
    <head>
        <title>HI</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha256-k2/8zcNbxVIh5mnQ52A0r3a6jAgMGxFJFE2707UxGCk= sha512-ZV9KawG2Legkwp3nAlxLIVFudTauWuBpC10uEafMHYL0Sarrz5A7G79kXh5+5+woxQ5HM559XX2UZjMJ36Wplg==" crossorigin="anonymous">
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
    </head>
    <body style="font-family: 'Open Sans', sans-serif;">
	<jsp:include page="commonheader.jsp"></jsp:include>
	${successupdate}
       <div class="container">
	<div class="row">
        <div class="col-sm-12">
            <legend>EDIT CATEGORY</legend>
        </div>
        <!-- panel preview -->
        <div class="col-sm-8" style="margin:0 auto;width:100%">
     
            <div class="panel panel-default">
                <div class="panel-body form-horizontal payment-form">
                <form:form action="validateupdate" method="post" commandname="Category">
                <div class="form-group">
                        <label for="concept" class="col-sm-3 control-label">CATEGORY ID</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="id" name="id" value="${ID}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="concept" class="col-sm-3 control-label">CATEGORYNAME</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="name" name="name" value="${NAME}"/>
                        </div>
                    </div>
                       <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">DESCRIPTION</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="description" name="description" value="${DESC}"/>
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