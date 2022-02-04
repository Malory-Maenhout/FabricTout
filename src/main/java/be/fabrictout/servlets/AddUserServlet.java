package be.fabrictout.servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class AddUser
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recovery of the session + test if it is valid
		HttpSession session = request.getSession(false);
		if(session != null)
		{	
			User user = (User)session.getAttribute("user");
			
			if( user != null)
			{		
				if(user.getDiscriminator().equals("ADMIN"))
				{
					//Recovery data and return to the jsp
					int id  = Integer.valueOf(request.getParameter("siteid"));
					request.setAttribute("idSite", id);
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddUser.jsp").forward(request, response);
				}
				else
				{
					session.setAttribute("error", "403");
					response.sendRedirect(request.getContextPath() + "/Error");
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/Login");
			}			
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recovery of the session + test if it is valid
		HttpSession session = request.getSession(false);
		if(session != null)
		{	
			User user = (User) session.getAttribute("user");
			
			if( user != null)
			{		
				if(user.getDiscriminator().equals("ADMIN"))
				{
					//Data retrieval to create a user
					int id  = Integer.valueOf(request.getParameter("idSite"));	
					
					String firstname = request.getParameter("txtFirstname");
					String lastname = request.getParameter("txtLastname");
					String address = request.getParameter("txtAddress");
					Date dateOfBirth = Date.valueOf(request.getParameter("txtDateOfBirth"));
					char sexe = request.getParameter("txtSexe").charAt(0);
					String city = request.getParameter("txtCity");
					int postalCode = Integer.valueOf(request.getParameter("txtPostalCode"));
					int phoneNumber = Integer.valueOf(request.getParameter("txtPhoneNumber"));
					String emailAddress = request.getParameter("txtEmailAddress");
					String personnelNumber = request.getParameter("txtPersonnelNumber");
					String password = request.getParameter("txtPassword");
					String discriminator = request.getParameter("txtDiscriminator");
						
					User addUser = null;
						
					switch(discriminator)
					{
						case "EMPLOYE":
							addUser = new Employee(firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, personnelNumber, password, discriminator, true);
							break;
						case "MANAGER":
							addUser = new Manager(firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, personnelNumber, password, discriminator, true);
							break;
						case "WORKER":
							addUser = new Worker(firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, personnelNumber, password, discriminator, true);
							break;
					}
					
					boolean verif = ((Administrator) user).createUser(id, addUser);
					
					if(verif)
					{	
						response.sendRedirect(request.getContextPath() + "/User?siteid=" + id + "");
					}
					else
					{
						session.setAttribute("error", "400");
						response.sendRedirect(request.getContextPath() + "/Error");
					}
				}
				else
				{
					session.setAttribute("error", "403");
					response.sendRedirect(request.getContextPath() + "/Error");
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/Login");
			}			
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}
}