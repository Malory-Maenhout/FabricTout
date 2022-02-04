<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="Home">FabricTout App</a>
	<div class="collapse navbar-collapse" id="navbar">
	  <ul class="navbar-nav mr-auto">
	    <li class="nav-item active">
	      <a class="nav-link" href="Home">Home</a>
	    </li>
	    <%
			String discriminator = (String) session.getAttribute("discriminator");
			if(discriminator.equals("ADMIN") || discriminator.equals("EMPLOYE"))
			{
				out.println("<li class=\"nav-item\">");
				out.println("<a class=\"nav-link\" href=\"Site\">Site</a>");
				out.println("</li>");
			}	
			else if (discriminator.equals("MANAGER"))
			{
				out.println("<li class=\"nav-item\">");
				out.println("<a class=\"nav-link\" href=\"Machine\">Machine</a>");
				out.println("</li>");
			}
			else if (discriminator.equals("WORKER"))
			{
				out.println("<li class=\"nav-item\">");
				out.println("<a class=\"nav-link\" href=\"Maintenance\">Maintenance</a>");
				out.println("</li>");
			}
		%>	    
	  </ul>
	  <form class="form-inline my-2 my-lg-0" action="LogoutServlet" method="POST">
	    <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log out</button>
	  </form>
	</div>
</nav>