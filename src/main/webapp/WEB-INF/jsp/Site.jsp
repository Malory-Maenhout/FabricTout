<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - site page</title>
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
						<h5>List of sites :</h5>
						
						<%
							if(discriminator.equals("ADMIN"))
								out.println("<a class=\"btn btn-lg btn-outline-success text-center\" href=\"AddSite\">Add site</a>");
						%>
								
					</div>
					<div class="card-body">
						<table class="table">
						  <thead class="table table-over table-secondary">
						     <tr>
						      <th scope="col">#</th>
						      <th scope="col">City</th>
						      <th scope="col">Country</th>
						      <th scope="col">List of areas</th>
						      
								<%
									if(discriminator.equals("ADMIN"))
									{
										out.println("<th scope=\"col\">List of users</th>");
									}								
								%>	
											      
						    </tr>
						  </thead>
						  <tbody>
						  
						  	<%
						  		List<Site> siteList = null;
						  	
								if(discriminator.equals("ADMIN"))
								{
									Administrator admin = (Administrator) session.getAttribute("user");
									siteList = admin.getSiteList();
								}       
								else
								{
									Employee emp = (Employee) session.getAttribute("user");
									siteList = emp.getSiteList();
								}
								
		  				  		for(Site site : siteList)
		  				  		{
		  				  			out.println("<tr>");
		  				  			out.println("<th scope=\"row\">" + site.getId() + "</th>");
		  				  			out.println("<td>" + site.getCity() + "</td>");
		  				  			out.println("<td>" + site.getCountry() + "</td>");
		  				  			out.println("<td><form method=\"GET\" action=\"Area\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"View the areas of the site\" ></form></td>");
		  				  			if(discriminator.equals("ADMIN"))
		  				  				out.println("<td><form method=\"GET\" action=\"User\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"View list of users\" ></form></td>");
		  				  			out.println("</tr>");
		  				  		}
					  		%>
					  	
						  </tbody>
						</table>
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