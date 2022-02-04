package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class AddAreaServlet
 */
public class AddAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recovery of the session + test if it is valid + recovery of the id of the site and return to the jsp
		HttpSession session = request.getSession(false);
		if(session != null)
		{	
			User user = (User)session.getAttribute("user");
			
			if( user != null)
			{		
				if(user.getDiscriminator().equals("ADMIN"))
				{
					//Recovery of idSite and return to the jsp
					int id  = Integer.valueOf(request.getParameter("siteid"));
					request.setAttribute("idSite", id);
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddArea.jsp").forward(request, response);
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
					//Data retrieval to create an area
					int id  = Integer.valueOf(request.getParameter("idSite"));
					char letter = request.getParameter("txtLetter").charAt(0);
					String color = request.getParameter("txtColor");
					String description = request.getParameter("txtDescription");
					description = description.replace("'", " ");
					description = description.replace("\"", " ");
						
					Area addArea = new Area(letter, color, description);
					
					boolean verif = ((Administrator) user).createArea(id, addArea);
					
					if(verif)
					{	
						response.sendRedirect(request.getContextPath() + "/Area?siteid=" + id + "");
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