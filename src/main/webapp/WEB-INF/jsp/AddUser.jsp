<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - add user page</title>
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
					<h5>Add a user :</h5>
				</div>
				<form class="form" method="POST" action="AddUser">
					<div class="card-body">
					    <div class="row">
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtFirstname">Firstname</label>
					                <input type="text" name='txtFirstname' id="txtFirstname" class="form-control" placeholder="Firstname" value='${firstname}' required>
					            </div>			   
					        </div>
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtLastname">Lastname</label>
					                <input type="text" name='txtLastname' id="txtLastname" class="form-control" placeholder="Lastname" value='${lastname}' required>
					            </div>
					        </div>
					    </div>
					    <div class="row">
					        <div class="col-9">
					            <div class="form-group">
					                <label for="txtAddress">Address</label>
					                <input type="text" name='txtAddress' id="txtAddress" class="form-control" placeholder="Address" value='${address}' required>
					            </div>
					        </div>
					        <div class="col-3">
					            <div class="form-group">
					                <label for="txtPhoneNumber">Phone number</label>
					                <input type="number" name='txtPhoneNumber' id="txtPhoneNumber" class="form-control" placeholder="Phone number" maxlength="10" value='${phoneNumber}' required>
					            </div>
					        </div>
					    </div>
					    <div class="row">
					    	<div class="col-6">
					            <div class="form-group">
					    			<label for="txtCity">City</label>
					            	<input type="text" name='txtCity' id="txtCity" class="form-control" placeholder="City" value='${city}' required>
					    		</div>
					    	</div>
					    	<div class="col-6">
					            <div class="form-group">
					    			<label for="txtPostalCode">Postal code</label>
					            	<input type="number" name='txtPostalCode' id="txtPostalCode" class="form-control" placeholder="Postal code" value='${postalCode}' required>
					    		</div>
					    	</div>
					    </div>
					    <div class="row">
					        <div class="col">
					            <div class="form-group">
					                <label for="txtDateOfBirth">Date of birth</label>
					                <input type="date" name='txtDateOfBirth' id="txtDateOfBirth" class="form-control" placeholder="Date of birth" value='${dateOfBirth}' required>
					            </div>
					        </div>
					        <div class="col">
					            <div class="form-group">
					                <label for="txtEmailAddress">EmailAddress</label>
					                <input type="email" name='txtEmailAddress' id="txtEmailAddress" class="form-control" placeholder="Email address" value='${email}' required>
					            </div>
					        </div>
					    </div>	
					    <div class="row">
					        <div class="col">
					            <div class="form-group">
					                <label for="txtSexe">Sexe</label>
					                <select class="form-control" name='txtSexe' id="txtSexe" required>
					                    <option value="H">Men</option>
					                    <option value="F">Women</option>
					                    <option value="O">Other</option>
					                </select>
					            </div>
					        </div>
					        <div class="col">
					            <div class="form-group">
					                <label for="txtDiscriminator">Type d'utilisateur</label>
					                <select class="form-control" name='txtDiscriminator' id="txtDiscriminator" required>
					                    <option value="EMPLOYE">Employe</option>
					                    <option value="MANAGER">Manager</option>
					                    <option value="WORKER">Worker</option>
					                </select>
					            </div>
					        </div>
					    </div> 
					    <div class="row">
					        <div class="col">
					            <div class="form-group">
					                <label for="txtPersonnelNumber">Personnel number</label>
					                <input type="text" name='txtPersonnelNumber' id="txtPersonnelNumber" class="form-control" placeholder="Personnel number" value='${personnelNumber}' required>
					            </div>
					        </div>
					        <div class="col-6">
					            <div class="form-group">
					                <label for="txtPassword">Password</label>
					                <input type="password" name='txtPassword' id="txtPassword" class="form-control" placeholder="Password" minlength="4" value='${password}' required>
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