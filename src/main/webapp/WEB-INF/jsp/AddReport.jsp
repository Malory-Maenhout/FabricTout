<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - add report page</title>
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
					<h5>Add a report :</h5>				
				</div>
				<form class="form" method="POST" action="AddReport">
					<div class="card-body">			
					    <div class="row">
					        <div class="col-3">
					            <div class="form-group">
					                <label for="txtFirstname">Firstname</label>
					                <input type="text" name='txtFirstname' id="txtFirstname" class="form-control text-capitalize" placeholder="Firstname" value='<%= request.getAttribute("Firstname") %>' readonly>
					            </div>			   
					        </div>
					        <div class="col-3">
					            <div class="form-group">
					                <label for="txtLastname">Lastname</label>
					                <input type="text" name='txtLastname' id="txtLastname" class="form-control text-capitalize" placeholder="Lastname" value='<%= request.getAttribute("Lastname") %>' readonly>
					            </div>			   
					        </div>
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtDate">Date</label>
					                <input type="date" name='txtDate' id="txtDate" class="form-control" placeholder="Date" value='${date}' required>
					            </div>			   
					        </div>
					    </div>   
					    <div class="row">
					        <div class="col">
					            <div class="form-group">
					                <label for="txtDescription">Description</label>
					                <textarea rows="10" maxlength=250 name='txtDescription' id="txtDescription" class="form-control" placeholder="Description" value='${description}' required></textarea>
					            </div>			   
					        </div>
					    </div> 
     				</div>
     				<div class="card-footer">
     					<div class="row">
					        <div class="col">
					        
					            <%
					        		out.println("<input hidden name=\"idMaintenance\" value=\"" + request.getAttribute("idMaintenance") + "\" />");
					        	%>
					        	
					        	<button class="btn btn-lg btn-outline-success btn-block" type="submit">Add</button>
					        </div>
					        <div class="col">  
					          
						        <%
						        	out.println("<a class=\"btn btn-lg btn-outline-danger btn-block\" href=\"MaintenanceDetails?maintenanceid=" + request.getAttribute("idMaintenance")+ "\">Back</a>");
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