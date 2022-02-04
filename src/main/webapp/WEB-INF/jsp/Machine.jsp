<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - machine page</title>
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
						<h5>List of machines :</h5>		
						
						<%
							if(discriminator.equals("EMPLOYE"))	
								out.println("<form method=\"GET\" action=\"AddMachine\"><input hidden name=\"siteid\" value=\"" + request.getAttribute("idSite") + "\" /><input hidden name=\"areaid\" value=\"" + request.getAttribute("idArea") + "\" /><input class=\"btn btn-lg btn-outline-success text-center\" type=\"submit\" value=\"Add machine\" ></form>");
						%>		
						
					</div>
					<div class="card-body">
						<table class="table">
						  <thead class="table table-over table-secondary">
						     <tr>
						      <th scope="col">#</th>
						      <th scope="col">Name</th>
						      <th scope="col">Status</th>
						      <th scope="col">Type</th>
						      <th scope="col">Details</th>
						      <th scope="col">Number of maintenance</th>
						      
							  <%
									if(discriminator.equals("EMPLOYE"))
										out.println("<th scope=\"col\">Delete</th>");	
							   %>	
											      
						    </tr>
						  </thead>
						  <tbody>
						  
						  	<%
						  		List<Machine> machineList = null;
						  		Area area = null;
						  	
								if(discriminator.equals("MANAGER"))
								{
									Manager manager = (Manager) session.getAttribute("user");
									machineList = manager.getMachineList();
								}       
								else
								{
									area = (Area) request.getAttribute("area");
									machineList = area.getMachineList();
								}
								
		  				  		for(Machine machine : machineList)
		  				  		{
		  				  			out.println("<tr>");
		  				  			out.println("<th scope=\"row\">" + machine.getId() + "</th>");
		  				  			out.println("<td>" + machine.getName() + "</td>");
		  				  			out.println("<td>" + machine.getStatus() + "</td>");
		  				  			out.println("<td>" + machine.getType() + "</td>");
		  				  			
			  				  		if(discriminator.equals("MANAGER"))
			  				  			out.println("<td><form method=\"GET\" action=\"MachineDetails\"><input hidden name=\"machineid\" value=\"" + machine.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"More details\" ></form></td>");
		  				  			else
		  				  				out.println("<td><form method=\"GET\" action=\"MachineDetails\"><input hidden name=\"siteid\" value=\"" + request.getAttribute("idSite") + "\" /><input hidden name=\"areaid\" value=\"" + area.getId() + "\" /><input hidden name=\"machineid\" value=\"" + machine.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"More details\" ></form></td>");
		  				  			
		  				  			out.println("<td>" + machine.getMaintenanceList().size() + "</td>");
		  				  			
		  				  			if(discriminator.equals("EMPLOYE"))
		  				  			{
			  				  			if(machine.isReplace())
		  				  					out.println("<td><input class=\"btn btn-sm btn-ligth\" type=\"submit\" value=\"X\" disabled></td>");
		  				  				else
		  				  					out.println("<td><form method=\"POST\" action=\"Machine\"><input hidden name=\"siteid\" value=\"" + request.getAttribute("idSite") + "\" /><input hidden name=\"areaid\" value=\"" + area.getId() + "\" /><input hidden name=\"machineid\" value=\"" + machine.getId() + "\" /><input class=\"btn btn-sm btn-outline-danger\" type=\"submit\" value=\"X\" ></form></td>");
		  				  			}
		  				  				
		  				  			out.println("</tr>");
		  				  		}
					  		%>
					  	
						  </tbody>
						</table>
	     			</div>
	     			<div class="card-footer">
	     				
	     				<%
	     					if(discriminator.equals("MANAGER"))
	     						out.println("<a class=\"btn btn-lg btn-outline-danger float-right\" href=\"Home\">Back</a>");
	     					else
	     						out.println("<a class=\"btn btn-lg btn-outline-danger float-right\" href=\"Area?siteid=" + request.getAttribute("idSite")+ "\">Back</a>");
	     				%>
	     				
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