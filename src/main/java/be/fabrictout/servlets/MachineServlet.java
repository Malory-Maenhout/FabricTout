package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class MachineServlet
 */
public class MachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachineServlet() {
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
				if(user.getDiscriminator().equals("EMPLOYE") || user.getDiscriminator().equals("MANAGER"))
				{
					if(user.getDiscriminator().equals("EMPLOYE"))
					{
						//Data recovery
						int idSite = Integer.valueOf(request.getParameter("siteid"));
						int id  = Integer.valueOf(request.getParameter("areaid"));
						Area area = Area.getArea(id);					
						request.setAttribute("idArea", area.getId());
						request.setAttribute("area", area);
						request.setAttribute("idSite", idSite);
					}
					
					//reload user for reload list in user
					User reloadUser = User.login(user.getPersonnelNumber(), user.getPassword());
					session.setAttribute("user", reloadUser);
					
					//return jsp
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/Machine.jsp").forward(request, response);
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
			User user = (User)session.getAttribute("user");
			
			if( user != null)
			{		
				if(user.getDiscriminator().equals("EMPLOYE"))
				{
					//Recovery of a machine to delete it
					int id  = Integer.valueOf(request.getParameter("machineid"));
					Machine deleteMachine = Machine.getMachine(id);
					deleteMachine.setReplace(true);
					
					boolean verif = ((Employee) user).deleteMachine(deleteMachine);
					
					if(verif)
					{	
						doGet(request, response);
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