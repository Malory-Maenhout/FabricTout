<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - add area page</title>
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
					<h5>Add an area :</h5>
				</div>
				<form class="form" method="POST" action="AddArea">
					<div class="card-body">
					    <div class="row">
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtLetter">Letter</label>
					                <input type="text" name='txtLetter' id="txtLetter" class="form-control" placeholder="Letter" value='${letter}' required>
					            </div>			   
					        </div>
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtColor">Color</label>
					                <select class="form-control" name='txtColor' id="txtColor" required>
					                    <option value="Grenn">Green</option>
					                    <option value="Orange">Orange</option>
					                    <option value="Red">Red</option>
					                    <option value="Black">Black</option>
					                </select>
					            </div>
					        </div>
					    </div>   
					    <div class="row">
					        <div class="col">
					            <div class="form-group">
					                <label for="txtDescription">Description</label>
					                <textarea rows="3" maxlength=250 name='txtDescription' id="txtDescription" class="form-control" placeholder="Description" value='${description}' required></textarea>
					            </div>			   
					        </div>
					    </div> 
     				</div>
     				<div class="card-footer">
     					<div class="row">
					        <div class="col">
					        
					            <%
					        		out.println("<input hidden name=\"idSite\" value=\"" + request.getAttribute("idSite") + "\" />");
					        	%>
					        	
					        	<button class="btn btn-lg btn-outline-success btn-block" type="submit">Add</button>
					        </div>
					        <div class="col">  
					          
						        <%
						        	out.println("<a class=\"btn btn-lg btn-outline-danger btn-block\" href=\"Area?siteid=" + request.getAttribute("idSite")+ "\">Back</a>");
						        %>   
						          
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