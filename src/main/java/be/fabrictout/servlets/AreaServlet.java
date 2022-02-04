package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class AreaServlet
 */
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaServlet() {
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
				if(user.getDiscriminator().equals("ADMIN") || user.getDiscriminator().equals("EMPLOYE"))
				{
					//Recovery data and return to the jsp
					int id  = Integer.valueOf(request.getParameter("siteid"));
					Site site = Site.getSite(id);
					request.setAttribute("site", site);
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/Area.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}