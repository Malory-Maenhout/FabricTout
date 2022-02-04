<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - maintenance page</title>
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
						<h5>List of maintenances :</h5>	
						
						<%
							Worker worker = (Worker) session.getAttribute("user");
							List<Maintenance> maintenanceList = worker.getMaintenanceList();
						%>
										
					</div>
					<div class="card-body">
					
						<%
							if(maintenanceList.size() > 0)
							{
						%>
						
						<table class="table">
						  <thead class="table table-over table-secondary">
						     <tr>
						      <th scope="col">#</th>
						      <th scope="col">Date</th>
						      <th scope="col">Duration (minutes)</th>
						      <th scope="col">Status</th>
						      <th scope="col">Details</th>								      
						    </tr>
						  </thead>
						  <tbody>
						  
						  	<%	
		  				  		for(Maintenance maintenance : maintenanceList)
		  				  		{
		  				  			out.println("<tr>");
		  				  			out.println("<th scope=\"row\">" + maintenance.getId() + "</th>");
		  				  			out.println("<td>" + maintenance.getDate() + "</td>");
		  				  			out.println("<td>" + maintenance.getDuration() + "</td>");
		  				  			out.println("<td>" + maintenance.getStatus() + "</td>");
			  				  		out.println("<td><form method=\"GET\" action=\"MaintenanceDetails\"><input hidden name=\"maintenanceid\" value=\"" + maintenance.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"More details\" ></form></td>");	
		  				  			out.println("</tr>");
		  				  		}
					  		%>
					  	
						  </tbody>
						</table>
						
						<%
							}
                        	else
                        	{
                        		out.println("<div class=\"text-center font-weight-bold text-danger\">You have no maintenance to do or invalid</div>");
                        	}
						%>
						
	     			</div>
	     			<div class="card-footer">     				
	     				<a class="btn btn-lg btn-outline-danger float-right" href="Home">Back</a>		
	     			</div>
		        </div>
	      </div>
    	</main>
    	  
	    <script>
		    <%@include file="/WEB-INF/js/bootstrap.min.js"%>
			<%@include file="/WEB-INF/js/popper.min.js"%>
	    </script>
	</body>
</html>