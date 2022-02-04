<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - add machine page</title>
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
					<h5>Add a machine :</h5>
				</div>
				<form class="form" id="machineForm" method="POST" action="AddMachine">
					<div class="card-body">
					    <div class="row">
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtName">Name</label>
					                <input type="text" name='txtName' id="txtName" class="form-control" placeholder="Name" value='${name}' required>
					            </div>			   
					        </div>
					        <div class="col-6">
					            <div class="form-group">
					    			<label for="txtSerialNumber">SerialNumber</label>
					            	<input type="text" name='txtSerialNumber' id="txtSerialNumber" class="form-control" placeholder="Serial number" value='${serialNumber}' required>
					    		</div>
					    	</div>
					    </div>	    
					    <div class="row">
					    	<div class="col-6">
					    		<div class="row">
						    		<div class="col-12">
							            <div class="form-group">
							                <label for="txtSize">Size</label>
							                <select class="form-control" name='txtSize' id="txtSize" required>
							                    <option value="Small">Small</option>
							                    <option value="Medium">Medium</option>
							                    <option value="Large">large</option>
							                </select>
							            </div>
							        </div>
							        <div class="col-12">
							            <div class="form-group">
							                <label for="txtStatus">Status</label>
							                <select class="form-control" name='txtStatus' id="txtStatus" required>
							                    <option value="Start">Start</option>
							                    <option value="Stop">Stop</option>
							                    <option value="Wait">Wait</option>
							                </select>
							            </div>
							        </div>
							        <div class="col-12">
							            <div class="form-group">
							                <label for="txtType">Type</label>
							                <select class="form-control" name='txtType' id="txtType" required>
							                    <option value="Sorting">Sorting</option>
							                    <option value="Assembly">Assembly</option>
							                    <option value="Manufacturing">Manufacturing</option>
							                </select>
							            </div>
							        </div>
					    		</div>
					    	</div>
					    	<div class="col-6">
						    	<div class="form-group">
								    <label for="txtAreaList">List of areas :</label>
								    <p class="text-muted">(Hold down your "ctrl" key to select multiple areas)</p>
								    <select multiple class="form-control" id="txtAreaList" name="txtAreaList" size="7" required>
								    
								    	<%
								    		Site s = (Site) request.getAttribute("Site");
								    		List<Area> areaList = s.getAreaList();
								    		
								    		for(Area a : areaList)
								    		{
			  				  					out.println("<option value=\"" + a.getId() + "\">Letter: " + a.getLetter() + " | Color: " + a.getColor() + "</option>");
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
					        		out.println("<input hidden name=\"idSite\" value=\"" + request.getAttribute("idSite") + "\" />");
					        		out.println("<input hidden name=\"idArea\" value=\"" + request.getAttribute("idArea") + "\" />");
					        	%>
					        	
					            <button class="btn btn-lg btn-outline-success btn-block" type="submit">Add</button>
					        </div>
					        <div class="col">
					        
						        <%
						        	out.println("<a class=\"btn btn-lg btn-outline-danger btn-block\" href=\"Machine?siteid=" + request.getAttribute("idSite") + "&areaid=" + request.getAttribute("idArea") + "\">Back</a>");
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