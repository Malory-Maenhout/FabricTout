<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - area page</title>
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
						<h5>List of areas :</h5>
						
						<%
							if(discriminator.equals("ADMIN"))
							{
								Site site = (Site) request.getAttribute("site");
								out.println("<form method=\"GET\" action=\"AddArea\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input class=\"btn btn-lg btn-outline-success\" type=\"submit\" value=\"Add Area\" ></form>");
							}
						%>
								
					</div>
					<div class="card-body">
						<table class="table">
						  <thead class="table table-over table-secondary">
						     <tr>
						      <th scope="col">#</th>
						      <th scope="col">Letter</th>
						      <th scope="col">Color</th>
						      <th scope="col">Description</th>
						      
								<%
									if(discriminator.equals("EMPLOYE"))
									{
										out.println("<th scope=\"col\">List of machines</th>");
									}								
								%>	
											      
						    </tr>
						  </thead>
						  <tbody>
						  
						  	<%
						  		Site site = (Site) request.getAttribute("site");
						  		List<Area> areaList = site.getAreaList();
								
		  				  		for(Area area : areaList)
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
		  				  			
		  				  			if(discriminator.equals("EMPLOYE"))
		  				  				out.println("<td><form method=\"GET\" action=\"Machine\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input hidden name=\"areaid\" value=\"" + area.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"View list of machines\" ></form></td>");
		  				  			
		  				  			out.println("</tr>");
		  				  		}
					  		%>
					  	
						  </tbody>
						</table>
	     			</div>
	     			<div class="card-footer">
	     				<a class="btn btn-lg btn-outline-danger float-right" href="Site">Back</a>
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