<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ page import="be.fabrictout.javabeans.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - maintenance details page</title>
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
                        <h5>Maintenance details :</h5>
                        <%
                        	Maintenance  maintenanceDetails = (Maintenance) request.getAttribute("maintenanceDetails");
                        	
                       		if(discriminator.equals("WORKER"))
								out.println("<form method=\"GET\" action=\"AddReport\"><input hidden name=\"maintenanceid\" value=\"" + maintenanceDetails.getId() + "\" /><input class=\"btn btn-lg btn-outline-success text-center\" type=\"submit\" value=\"Add report\" ></form>");
					
                        %>
                    </div>		
                    <div class="card-body">
                    	<form class="form" method="POST" action="MaintenanceDetails">
                    		<div class="row">
                                <div class="col-12">
                                    <p class="font-weight-bold">Maintenance</p>
                    				<hr>
                                </div>
                                <div class="col-2">
                                    <div class="form-group">
                                        <label for="txtId">Id</label>
                                        <input type="text" name='txtId' id="txtId" class="form-control" placeholder="Id" value='<%= maintenanceDetails.getId() %>' readonly>
                                    </div>			   
                                </div>
                                <div class="col-4">
                                    <div class="form-group">
                                        <label for="txtDate">Date</label>
                                        <input type="text" name='txtDate' id="txtDate" class="form-control" placeholder="Date" value='<%= maintenanceDetails.getDate() %>' readonly>
                                    </div>			   
                                </div>
                                <div class="col-3">
                                    <div class="form-group">
                                        <label for="txtDuration">Duration (minutes)</label>
                                        <input type="text" name='txtDuration' id="txtDuration" class="form-control" placeholder="Duration" value='<%= maintenanceDetails.getDuration() %>' readonly>
                                    </div>			   
                                </div>
                                <div class="col-3">
                                    
                                    <%
		   								if(discriminator.equals("MANAGER"))
		   								{                                   		
						        	%>
						        	
	                                <div class="form-group">
						                <label for="txtStatusM">Status</label>
						                <select class="form-control" name='txtStatusM' id="txtStatusM" required>
						                    <option value="Do"<% if (maintenanceDetails.getStatus().toString().equals("Do")) { out.println("selected"); } %>>Do</option>
						                    <option value="ToDo"<% if (maintenanceDetails.getStatus().toString().equals("ToDo")) { out.println("selected"); } %>>ToDo</option>
						                    <option value="Validate"<% if (maintenanceDetails.getStatus().toString().equals("Validate")) { out.println("selected"); } %>>Validate</option>
						                    <option value="InValidate"<% if (maintenanceDetails.getStatus().toString().equals("InValidate")) { out.println("selected"); } %>>InValidate</option>
						                </select>
						            </div>
						            
						            <%
		   								}
		   								else
		   								{
						            %>
						            	
						            <div class="form-group">
                                        <label for="txtStatusM">Status</label>
                                        <input type="text" name='txtStatusM' id="txtStatusM" class="form-control" placeholder="Status" value='<%= maintenanceDetails.getStatus() %>' readonly>
                                    </div>
						            	
						            <%
		   								}                                  		
						        	%>
						        	
                                </div>
                            </div>
                            
                            <%
   								if(discriminator.equals("MANAGER"))
   								{
   									out.println("<input hidden name=\"maintenanceid\" value=\"" + maintenanceDetails.getId() + "\" />");
				        			out.println("<input hidden name=\"machineid\" value=\"" + request.getAttribute("idMachine") + "\" />");                                    		
				        	%>
				        	
				        	<div class="row">
				        		<div class="col">
                        			<button class="btn btn-md btn-outline-success float-right" type="submit">Edit status</button>
				        		</div>
				        	</div>
                            
                            <%
                           		}
                            
                            	Machine machineDetails = maintenanceDetails.getMachine();
                            %>
                    		
                 			<hr>
                    		<div class="row">
                    			<div class="col-12">
                    				<p class="font-weight-bold">Machine :</p>
                    				<hr>
                    			</div>
	                            <div class="col-2">
	                                <div class="form-group">
	                                    <label for="txtId">Id</label>
	                                    <input type="text" name='txtId' id="txtId" class="form-control" placeholder="Id" value='<%= machineDetails.getId() %>' readonly>
	                                </div>			   
	                            </div>
	                            <div class="col-4">
	                                <div class="form-group">
	                                    <label for="txtName">Name</label>
	                                    <input type="text" name='txtName' id="txtName" class="form-control" placeholder="Name" value='<%= machineDetails.getName() %>' readonly>
	                                </div>			   
	                            </div>
	                            <div class="col-4">
	                                <div class="form-group">
	                                    <label for="txtSerialNumber">Serial number</label>
	                                    <input type="text" name='txtSerialNumber' id="txtSerialNumber" class="form-control" placeholder="SerialNumber" value='<%= machineDetails.getSerialNumber() %>' readonly>
	                                </div>			   
	                            </div>
	                            <div class="col-2">
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
	                                <div class="form-group">
	                                    <label for="txtStatus">Status</label>
	                                    <input type="text" name='txtStatus' id="txtStatus" class="form-control" placeholder="Status" value='<%= machineDetails.getStatus() %>' readonly>
	                                </div>
	                            </div>
	                            <div class="col-4">
	                                <div class="form-group">
	                                    <label for="txtType">Type</label>
	                                    <input type="text" name='txtType' id="txtType" class="form-control" placeholder="Type" value='<%= machineDetails.getType() %>' readonly>
	                                </div>
	                            </div>
	                        </div>
	                        
                 			<hr>
	                        <div class="row">
	                        	<div class="col-12">
	                        		<p class="font-weight-bold">List of areas :</p>
	                        	</div>
	                        	<div class="col">
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
	                        	</div>
	                        </div>
	                        
	                        <hr>
	                        <div class="row">
	                        	<div class="col-12">
	                        		<p class="font-weight-bold">List of workers :</p>
	                        	</div>
	                        	<div class="col">
	                        		<table class="table table-hover table-sm">
		                                <thead>
		                                    <tr>
		                                        <th>#</th>
		                                        <th>FirstName</th>
		                                        <th>LastName</th>
		                                        <th>Phone number</th>
		                                        <th>Personnel number<th>
		                                    </tr>
		                                </thead>
		                                <tbody>
	                                		<%
		                                		for(Worker worker: maintenanceDetails.getWorkerList())
		                                		{
		                                			
		        		  				  			out.println("<tr>");
		                                			out.println("<th scope=\"row\">" + worker.getId() + "</th>");
		        		  				  			out.println("<td>" + worker.getFirstname() + "</td>");
		        		  				  			out.println("<td>" + worker.getLastname() + "</td>");
		        		  				  			out.println("<td>" + worker.getPhoneNumber() + "</td>");		
		        		  				  			out.println("<td>" + worker.getPersonnelNumber() + "</td>");
			                                    	out.println("</tr>");
		                                		}
		                                	%>	                            
		                                </tbody>
		                            </table>
	                        	</div>
	                        </div>
	                                 
                            <%
                            	if(maintenanceDetails.getReportList().size() > 0)
                            	{
                            %>
	                                                                      
	                        <hr>
	                        <div class="row">
	                        	<div class="col-12">
	                        		<p class="font-weight-bold">List of reports :</p>
	                        	</div>
	                        	<div class="col">
	                        		<table class="table table-hover table-sm">
		                                <thead>
		                                    <tr>
		                                        <th>#</th>
		                                        <th>Firstname editor</th>
		                                        <th>Lastname editor</th>
		                                        <th>Date</th>
		                                        <th>Description<th>
		                                    </tr>
		                                </thead>
		                                <tbody>
	                                		<%
		                                		for(Report report: maintenanceDetails.getReportList())
		                                		{
		                                			
		        		  				  			out.println("<tr>");
		                                			out.println("<th scope=\"row\">" + report.getId() + "</th>");
		        		  				  			out.println("<td>" + report.getWorker().getFirstname() + "</td>");
		        		  				  			out.println("<td>" + report.getWorker().getLastname() + "</td>");
		        		  				  			out.println("<td>" + report.getDate()+ "</td>");
		        		  				  			out.println("<td>" + report.getDescription()+ "</td>");
			                                    	out.println("</tr>");
		                                		}
		                                	%>	                            
		                                </tbody>
		                            </table>
	                        	</div>
	                        </div>  
	                        <%
                            	}
                            	else
                            	{
                            		out.println("<div class=\"text-center font-weight-bold text-danger\">No report created yet for this maintenance</div>");
                            	}
                            %>           
                    	</form>
                    </div>
                     <div class="card-footer">
					     <div class="row">
					         <div class="col">
					
					         <%
					         	if(discriminator.equals("WORKER"))
					        		 out.println("<a class=\"btn btn-lg btn-outline-danger float-right\" href=\"Maintenance\">Back</a>");
					        	 else
					         		out.println("<a class=\"btn btn-lg btn-outline-danger float-right\" href=\"MachineDetails?machineid=" + request.getAttribute("idMachine") + "\">Back</a>");
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