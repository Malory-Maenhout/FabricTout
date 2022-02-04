<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - add maintenance page</title>
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
					<h5>Add a maintenance :</h5>
				</div>
				<form class="form" method="POST" action="AddMaintenance">
					<div class="card-body">				    
					    <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="txtDate">Date</label>
                                    <input type="date" name='txtDate' id="txtDate" class="form-control" placeholder="Date" value='${date}' required>
                                </div>               
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="txtDuration">Duration</label>
                                    <input type="number" name='txtDuration' id="txtDuration" class="form-control" placeholder="Duration in minutes" value='${duration}' required>
                                </div>               
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="form-group">
                                    <label for="txtWorkerList">List of workers :</label>
                                    <p class="text-muted">(Hold down your "ctrl" key to select multiple areas)</p>
                                    <select multiple class="form-control" name='txtWorkerList' id="txtWorkerList" size="7" required>

                                        <%
                                        	List<Worker> workerList = (List<Worker>) request.getAttribute("workerList");
								    		
								    		for(Worker w : workerList)
								    		{
			  				  					out.println("<option value=\"" + w.getId() + "\"> Firstname: " + w.getFirstname() + " | Lastname: " + w.getLastname() + " | sexe: " + w.getSexe() + "</option>");
								    		}
								     	%>

                                    </select>
                                </div>
                            </div>
                        </div>
					    
     				</div>
     				<div class="card-footer">
     					<div class="row">
					        <div class="col">
					        
					            <%
					        		out.println("<input hidden name=\"idMachine\" value=\"" + request.getAttribute("idMachine") + "\" />");
					        	%>
					        	
					        	<button class="btn btn-lg btn-outline-success btn-block" type="submit">Add</button>
					        </div>
					        <div class="col">  
					          
						        <%
						        	out.println("<a class=\"btn btn-lg btn-outline-danger btn-block\" href=\"MachineDetails?machineid=" + request.getAttribute("idMachine")+ "\">Back</a>");
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