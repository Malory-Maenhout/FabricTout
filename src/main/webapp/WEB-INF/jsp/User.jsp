<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="be.fabrictout.javabeans.*" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FabricTout - user page</title>
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
						<h5>List of users :</h5>
						
						<%
							Site site = (Site) request.getAttribute("site");
							out.println("<form method=\"GET\" action=\"AddUser\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input class=\"btn btn-lg btn-outline-success\" type=\"submit\" value=\"Add user\" ></form>");
						%>
						
					</div>
					<div class="card-body">
						<table class="table">
						  <thead class="table table-over table-secondary">
						     <tr>
						      <th scope="col">#</th>
						      <th scope="col">Firstname</th>
						      <th scope="col">Name</th>
						      <th scope="col">Sexe</th>
						      <th scope="col">Phone number</th>
						      <th scope="col">Email address</th>
						      <th scope="col">Discriminator</th>
						      <th scope="col">Details</th>		
						      <th scope="col">Delete</th>		      
						    </tr>
						  </thead>
						  <tbody>
						  
						  	<%	  		
					  			List<User> userList = site.getUserList();
						  	
								for(User user : userList)
		  				  		{
		  				  			out.println("<tr>");
		  				  			out.println("<th scope=\"row\">" + user.getId() + "</th>");
		  				  			out.println("<td>" + user.getFirstname() + "</td>");
		  				  			out.println("<td>" + user.getLastname() + "</td>");
		  				  			if(user.getSexe() == 'H')
		  				  				out.println("<td>Homme</td>");
		  				  			else
		  				  				out.println("<td>Femme</td>");
		  				  			out.println("<td>" + user.getPhoneNumber() + "</td>");
		  				  			out.println("<td>" + user.getEmailAddress() + "</td>");
		  				 			out.println("<td>" + user.getDiscriminator().toLowerCase() + "</td>");
		  				 			
		  				 			if(!user.getDiscriminator().equals("ADMIN"))
		  				 			{
		  				 				out.println("<td><form method=\"GET\" action=\"UserDetails\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input hidden name=\"userid\" value=\"" + user.getId() + "\" /><input class=\"btn btn-sm btn-outline-primary\" type=\"submit\" value=\"More details\" ></form></td>");
		  				 				out.println("<td><form method=\"POST\" action=\"User\"><input hidden name=\"siteid\" value=\"" + site.getId() + "\" /><input hidden name=\"userid\" value=\"" + user.getId() + "\" /><input class=\"btn btn-sm btn-outline-danger\" type=\"submit\" value=\"X\" ></form></td>");
		  				 			}
		  				 			else
		  				 			{
		  				 				out.println("<td><input class=\"btn btn-sm btn-light\" type=\"submit\" value=\"More details\" disabled></td>");
		  				 				out.println("<td><input class=\"btn btn-sm btn-ligth\" type=\"submit\" value=\"X\" disabled></td>");
		  				 			}

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