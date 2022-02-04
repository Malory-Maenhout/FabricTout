<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - machine details page</title>
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
						<h5>Machine details :</h5>
						
						<%
							Machine machineDetails = (Machine) request.getAttribute("machineDetails");
						
							if(discriminator.equals("MANAGER"))
								out.println("<form method=\"GET\" action=\"AddMaintenance\"><input hidden name=\"machineid\" value=\"" + machineDetails.getId() + "\" /><input class=\"btn btn-lg btn-outline-success text-center\" type=\"submit\" value=\"Add maintenance\" ></form>");
						%>
						
					</div>		
					<div class="card-body">
						<form class="form" method="POST" action="MachineDetails">
							<div class="row">
	                            <div class="col-1">
	                                <div class="form-group">
	                                    <label for="txtId">Id</label>
	                                    <input type="text" name='txtId' id="txtId" class="form-control" placeholder="Id" value='<%= machineDetails.getId() %>' readonly>
	                                </div>			   
	                            </div>
	                            <div class="col-5">
	                                <div class="form-group">
	                                    <label for="txtName">Name</label>
	                                    <input type="text" name='txtName' id="txtName" class="form-control" placeholder="Name" value='<%= machineDetails.getName() %>' readonly>
	                                </div>			   
	                            </div>
	                            <div class="col-5">
	                                <div class="form-group">
	                                    <label for="txtSerialNumber">Serial number</label>
	                                    <input type="text" name='txtSerialNumber' id="txtSerialNumber" class="form-control" placeholder="SerialNumber" value='<%= machineDetails.getSerialNumber() %>' readonly>
	                                </div>			   
	                            </div>
	                            <div class="col-1">
	                                <div class="form-group">
	                                    <label for="txtReplace">Replace</label>
	                                    <input type="text" name='txtReplace' id="txtReplace" class="form-control" placeholder="Replace" value='<%= machineDetails.isReplace() %>' readonly>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="row">
	                            <div class="col-4">
	                                <div class="form-group">
	                                    <label for="txtSize">Size</label>
	                                    <input type="text" name='txtSize' id="txtSize" class="form-control" placeholder="Size" value='<%= machineDetails.getSize() %>' readonly>
	                                </div>
	                            </div>
	                            <div class="col-4">
	                            
	                           		<%
		   								if(discriminator.equals("MANAGER"))
		   								{                                   		
						        	%>
						        	
	                                <div class="form-group">
						                <label for="txtStatus">Status</label>
						                <select class="form-control" name='txtStatus' id="txtStatus" required>
						                    <option value="Start"<% if (machineDetails.getStatus().toString().equals("Start")) { out.println("selected"); } %>>Start</option>
						                    <option value="Stop"<% if (machineDetails.getStatus().toString().equals("Stop")) { out.println("selected"); } %>>Stop</option>
						                    <option value="Wait"<% if (machineDetails.getStatus().toString().equals("Wait")) { out.println("selected"); } %>>Wait</option>
						                </select>
						            </div>
						            
						            <%
		   								}
		   								else
		   								{
						            %>
						            	
						            <div class="form-group">
	                                    <label for="txtStatus">Status</label>
	                                    <input type="text" name='txtStatus' id="txtStatus" class="form-control" placeholder="Status" value='<%= machineDetails.getStatus() %>' readonly>
	                                </div>
						            	
						            <%
		   								}                                  		
						        	%>
						        	
	                            </div>
	                            <div class="col-4">
	                                <div class="form-group">
	                                    <label for="txtType">Type</label>
	                                    <input type="text" name='txtType' id="txtType" class="form-control" placeholder="Type" value='<%= machineDetails.getType() %>' readonly>
	                                </div>
	                            </div>
	                        </div>
	                        
   							<%
   								if(discriminator.equals("MANAGER"))
   								{
				        			out.println("<input hidden name=\"machineid\" value=\"" + machineDetails.getId() + "\" />");                                    		
				        	%>
				        	
				        	<div class="row">
				        		<div class="col">
                        			<button class="btn btn-md btn-outline-success float-right" type="submit">Edit status</button>
				        		</div>
				        	</div>
	                        
	                        <%
   								}                                  		
				        	%>
				        	
                         </form>
                            <hr>
				  	    	<div class="text-center font-weight-bold">List of areas :</div>
                            <table class="table table-hover table-sm">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Letter</th>
                                        <th>Color</th>
                                        <th>Description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                	<%
                                		for(Area area: machineDetails.getAreaList())
                                		{
                                			switch(String.valueOf(area.getColor()))
        		  				  			{
        		  				  				case "Green":
        		  				  					out.println("<tr class=\"table-success\">");
        		  				  					break;
        				  				  		case "Orange":
        				  				  			out.println("<tr class=\"table-warning\">");
        			  				  				break;
        				  				  		case "Red":
        				  				  			out.println("<tr class=\"table-danger\">");
        		  				  					break;
        				  				  		case "Black":
        				  				  			out.println("<tr class=\"table-secondary\">");
        						  					break;
        		  				  			}
                                			
                                			out.println("<th scope=\"row\">" + area.getId() + "</th>");
        		  				  			out.println("<td>" + area.getLetter() + "</td>");
        		  				  			out.println("<td>" + area.getColor() + "</td>");
        		  				  			out.println("<td>" + area.getDescription()+ "</td>");
        		  				  			out.println("</tr>");
                                		}
                                	%>
                            
                                </tbody>
                            </table>
                            
                            <hr>
                                 
                            <%
                            	if(machineDetails.getMaintenanceList().size() > 0)
                            	{
                            %>
                            
				  	    	<div class="text-center font-weight-bold">List of maintenances :</div>
                            <table class="table table-hover table-sm">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Date</th>
                                        <th>Duration (minutes)</th>
                                        <th>Status</th>
                                        
                                        <%
                                        	if(discriminator.equals("MANAGER"))
                                        		out.println("<th>Details</th>");
                                        %>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    <%
                                    	List<Maintenance> maintenanceList = machineDetails.getMaintenanceList();
                                    
                                		for(Maintenance maintenance: maintenanceList)
                                		{                              			
        		  				  			out.println("<tr>");
                                			out.println("<th scope=\"row\">" + maintenance.getId() + "</th>");
        		  				  			out.println("<td>" + maintenance.getDate() + "</td>");
        		  				  			out.println("<td>" + maintenance.getDuration() + "</td>");
        		  				  			out.println("<td>" + maintenance.getStatus()+ "</td>");
        		  				  			
	                                    	if(discriminator.equals("MANAGER"))
	                                    	{
	                                    		out.println("<td><form method=\"GET\" action=\"MaintenanceDetails\">" +
	                                    		"<input hidden name=\"machineid\" value=\"" + machineDetails.getId() + "\" />" +
	                                    		"<input hidden name=\"maintenanceid\" value=\"" + maintenance.getId() + "\" />" +
	                                    		"<input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"More details\"></form></td>");
	                                    	}
	                                    		
	                                    	out.println("</tr>");
                                		}
                                	%>
                                	
                                </tbody>
                            </table>
                            
                            <%
                            	}
                            	else
                            	{
                            		out.println("<div class=\"text-center font-weight-bold text-danger\">No maintenance done yet for this machine</div>");
                            	}
                            %>
                            
     				</div>
     				<div class="card-footer">
					    <div class="row">
					        <div class="col">
					        
					         	<%
					         		if(discriminator.equals("MANAGER"))
					         			out.println("<a class=\"btn btn-lg btn-outline-danger float-right\" href=\"Machine\">Back</a>");
					         		else
					         			out.println("<a class=\"btn btn-lg btn-outline-danger float-right\" href=\"Machine?siteid=" + request.getAttribute("idSite") + "&areaid=" + request.getAttribute("idArea") + "\">Back</a>");
						        %>
						        
					        </div> 
					    </div>
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