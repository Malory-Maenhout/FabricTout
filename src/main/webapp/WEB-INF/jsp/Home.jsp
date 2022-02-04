<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - home page</title>
		<style>
		    <%@include file="/WEB-INF/css/bootstrap.min.css"%>
    		<%@include file="/WEB-INF/css/style.css"%>
		</style>
	</head>
	<body>
		<%@include file="/WEB-INF/jsp/Navigation.jsp"%>

	    <main role="main" class="container">
	      <div class="starter-template">

	        <%
	        	User user = null;
	        	switch(discriminator)
	        	{
	        		case "ADMIN":
	        			user = (Administrator) session.getAttribute("user");
	        			break;
	        		case "EMPLOYE":
	        			user = (Employee) session.getAttribute("user");
	        			break;
	        		case "MANAGER":
	        			user = (Manager) session.getAttribute("user");
	        			break;
	        		case "WORKER":
	        			user = (Worker) session.getAttribute("user");
	        			if((boolean)request.getAttribute("notification"))
	        			{
	        				out.println("<div class=\"alert alert-warning\" role=\"alert\">");
	        				out.println("You have at least one maintenance to do ! <a href=\"Maintenance\" class=\"alert-link\">List of maintenance</a>");
	        				out.println("</div>");
	        				out.println("</br>");
	        			}     			
	        			break;
	        	}
	        %>
	        
	        <h1>Welcome to the FabricTout application !</h1>     
	        <p class="lead">Hello dear <%= user.getLastname()%><br>
	        You can use the navigation bar to navigate through the application.</p>
	      </div>		
    	</main>
	    
	    <script>
		    <%@include file="/WEB-INF/js/bootstrap.min.js"%>
			<%@include file="/WEB-INF/js/popper.min.js"%>
	    </script>
	</body>
</html>