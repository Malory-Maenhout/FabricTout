<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - add site page</title>
		<style>
		    <%@include file="/WEB-INF/css/bootstrap.min.css"%>
    		<%@include file="/WEB-INF/css/style.css"%>
		</style>
	</head>
	<body>
		<%@include file="/WEB-INF/jsp/Navigation.jsp"%>

	    <main role="main" class="container">
	      <div class="starter-template">
	      	<div class="card tailleListClient">
				<div class="card-header">
					<h5>Add a site :</h5>
				</div>
				<form class="form" method="POST" action="AddSite">
					<div class="card-body">
					    <div class="row">
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtCity">City</label>
					                <input type="text" name='txtCity' id="txtCity" class="form-control" placeholder="City" value='${city}' required>
					            </div>			   
					        </div>
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtCountry">Country</label>
					                <input type="text" name='txtCountry' id="txtCountry" class="form-control" placeholder="Country" value='${country}' required>
					            </div>
					        </div>
					    </div>    
					    
					    <%
					    	if(request.getAttribute("error") != null)
					    	{
					    %>	
							    <div class="row">
							        <div class="col">
							            <h6 class="text-danger"><%= request.getAttribute("error") %></h6>	   
							        </div>
							    </div>	
					    <%
					    	}
					    %>
					    
     				</div>
     				<div class="card-footer">
     					<div class="row">
					        <div class="col">
					            <button class="btn btn-lg btn-outline-success btn-block" type="submit">Add</button>
					        </div>
					        <div class="col">    
						        <a class="btn btn-lg btn-outline-danger float-right btn-block" href="Site">Back</a>     
					        </div> 
					    </div>
     				</div>
     			</form>
	        </div>
	      </div>
    	</main>
    	  
	    <script>
		    <%@include file="/WEB-INF/js/bootstrap.min.js"%>
			<%@include file="/WEB-INF/js/popper.min.js"%>
	    </script>
	</body>
</html>