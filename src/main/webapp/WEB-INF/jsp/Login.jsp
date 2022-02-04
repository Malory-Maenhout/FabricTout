<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>

<%!
	private String formatMessage(String message)
	{
		return "<font color=\"red\">" + message + "</font>";
	}
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - login page</title>  	
    	<style>
    		<%@include file="/WEB-INF/css/bootstrap.min.css"%>
    		<%@include file="/WEB-INF/css/style.css"%>
    	</style>
	</head>
	<body>
	
		<%
			ArrayList<String> errors = (ArrayList<String>) request.getAttribute("errors");
		%>
	
		<div class="back">
			<div class="div-center">
				<div class="content">
					<h3>FabricTout - Login</h3>
			    	<hr />
			        <form action="LoginServlet" method="POST">
			          <div class="form-group">
			            <label for="inputPersonnelNumber">Personnel number</label>
			            <input type="Text" class="form-control" id="inputPersonnelNumber" name="inputPersonnelNumber" placeholder="Personnel number">
			          </div>
			          <div class="form-group">
			            <label for="inputPassword">Password</label>
			            <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password">
			          </div>
			          
			          <%
			         	 if(errors != null)
							{
			          %>
				          <div>
				          	<ul>
								<%	
										for(String error : errors)
										{			
								%>
											<li><%= this.formatMessage(error)%></li>
								<% 
										}
								%>
						  	</ul>
				          </div>
			          <% 
							}
			          %>         
			          
			          <button type="submit" name="submit" id="submit" value="Login" class="btn btn-primary">Log in</button>
			      	</form>
				</div>	 
			</div>
		</div>
	</body>
</html>