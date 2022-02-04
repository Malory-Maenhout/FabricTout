<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - user details page</title>
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
						<h5>User details :</h5>
						<h6>You can modify fields in this form if necessary</h6>
						
						<%
							User userDetails = (User) request.getAttribute("userDetails");
						%>
						
					</div>
					<form class="form" method="POST" action="UserDetails">
						<div class="card-body">
						    <div class="row">
						        <div class="col-6">
						            <div class="form-group">
						                <label for="txtFirstname">Firstname</label>
						                <input type="text" name='txtFirstname' id="txtFirstname" class="form-control" placeholder="Firstname" value='<%= userDetails.getFirstname() %>' required>
						            </div>			   
						        </div>
						        <div class="col-6">
						            <div class="form-group">
						                <label for="txtLastname">Lastname</label>
						                <input type="text" name='txtLastname' id="txtLastname" class="form-control" placeholder="Lastname" value='<%= userDetails.getLastname() %>' required>
						            </div>
						        </div>
						    </div>
						    <div class="row">
						        <div class="col-9">
						            <div class="form-group">
						                <label for="txtAddress">Address</label>
						                <input type="text" name='txtAddress' id="txtAddress" class="form-control" placeholder="Address" value='<%= userDetails.getAddress() %>' required>
						            </div>
						        </div>
						        <div class="col-3">
						            <div class="form-group">
						                <label for="txtPhoneNumber">Phone number</label>
						                <input type="number" name='txtPhoneNumber' id="txtPhoneNumber" class="form-control" placeholder="Phone number" maxlength="10" value='<%= userDetails.getPhoneNumber() %>' required>
						            </div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-6">
						            <div class="form-group">
						    			<label for="txtCity">City</label>
						            	<input type="text" name='txtCity' id="txtCity" class="form-control" placeholder="City" value='<%= userDetails.getCity() %>' required>
						    		</div>
						    	</div>
						    	<div class="col-6">
						            <div class="form-group">
						    			<label for="txtPostalCode">Postal code</label>
						            	<input type="number" name='txtPostalCode' id="txtPostalCode" class="form-control" placeholder="Postal code" value='<%= userDetails.getPostalCode() %>' required>
						    		</div>
						    	</div>
						    </div>
						    <div class="row">
						        <div class="col">
						            <div class="form-group">
						                <label for="txtDateOfBirth">Date of birth</label>
						                <input type="date" name='txtDateOfBirth' id="txtDateOfBirth" class="form-control" placeholder="Date of birth" value='<%= userDetails.getDateOfBirth() %>' required>
						            </div>
						        </div>
						        <div class="col">
						            <div class="form-group">
						                <label for="txtEmailAddress">EmailAddress</label>
						                <input type="email" name='txtEmailAddress' id="txtEmailAddress" class="form-control" placeholder="Email address" value='<%= userDetails.getEmailAddress() %>' required>
						            </div>
						        </div>
						    </div>	
						    <div class="row">
						        <div class="col">
						            <div class="form-group">
						                <label for="txtSexe">Sexe</label>
						                <select class="form-control" name='txtSexe' id="txtSexe" required>
						                    <option value="H" <% if (userDetails.getSexe() == 'H') { out.println("selected"); } %>>Men</option>
						                    <option value="F" <% if (userDetails.getSexe() == 'F') { out.println("selected"); } %>>Women</option>
						                    <option value="O" <% if (userDetails.getSexe() == 'O') { out.println("selected"); } %>>Other</option>
						                </select>
						            </div>
						        </div>
						        <div class="col">
						            <div class="form-group">
						                <label for="txtDiscriminator">Type d'utilisateur</label>
						                <select class="form-control" name='txtDiscriminator' id="txtDiscriminator" required>
						                    <option value="EMPLOYE" <% if (userDetails.getDiscriminator().equals("EMPLOYE")) { out.println("selected"); } %>>Employe</option>
						                    <option value="MANAGER" <% if (userDetails.getDiscriminator().equals("MANAGER")) { out.println("selected"); } %>>Manager</option>
						                    <option value="WORKER" <% if (userDetails.getDiscriminator().equals("WORKER")) { out.println("selected"); } %>>Worker</option>
						                </select>
						            </div>
						        </div>
						    </div> 
						    <div class="row">
						        <div class="col">
						            <div class="form-group">
						                <label for="txtPersonnelNumber">Personnel number</label>
						                <input type="text" name='txtPersonnelNumber' id="txtPersonnelNumber" class="form-control" placeholder="Personnel number" value='<%= userDetails.getPersonnelNumber() %>' required>
						            </div>
						        </div>
						        <div class="col-6">
						            <div class="form-group">
						                <label for="txtPassword">Password</label>
						                <input type="text" name='txtPassword' id="txtPassword" class="form-control" placeholder="Password" minlength="4" value='<%= userDetails.getPassword() %>' required>
						            </div>
						        </div>
						    </div>
	     				</div>
	     				<div class="card-footer">
						    <div class="row">
						        <div class="col">
						        
						        	<%
						        		out.println("<input hidden name=\"idUser\" value=\"" + userDetails.getId() + "\" />");
						        		out.println("<input hidden name=\"idSite\" value=\"" + request.getAttribute("idSite") + "\" />");
						        	%>
						        	
						            <button class="btn btn-lg btn-outline-success btn-block" type="submit">Edit</button>
						        </div>
						        <div class="col">
						        
						         	<%
							        	out.println("<a class=\"btn btn-lg btn-outline-danger btn-block\" href=\"User?siteid=" + request.getAttribute("idSite")+ "\">Back</a>");
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