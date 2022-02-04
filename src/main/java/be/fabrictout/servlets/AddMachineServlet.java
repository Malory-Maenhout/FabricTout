package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class AddMachineServlet
 */
public class AddMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMachineServlet() {
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
				if(user.getDiscriminator().equals("EMPLOYE"))
				{
					//Recovery of data (idSite and idArea) + recovery of site + return to the jsp
					int idSite  = Integer.valueOf(request.getParameter("siteid"));
					int idArea  = Integer.valueOf(request.getParameter("areaid"));
					request.setAttribute("idSite", idSite);
					request.setAttribute("idArea", idArea);
					
					Site site = Site.getSite(idSite);
					request.setAttribute("Site", site);
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddMachine.jsp").forward(request, response);
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
				if(user.getDiscriminator().equals("EMPLOYE"))
				{	
					//Data retrieval to create a machine
					int idSite  = Integer.valueOf(request.getParameter("idSite"));
	        		int idArea = Integer.valueOf(request.getParameter("idArea"));
	        		
					String name = request.getParameter("txtName");
					String serialNumber = request.getParameter("txtSerialNumber");
					String size = request.getParameter("txtSize");
					String status = request.getParameter("txtStatus");
					String type = request.getParameter("txtType");
					
					Machine addMachine = new Machine(name, size, status, false, serialNumber, type);
					
					String[] addAreaList = request.getParameterValues("txtAreaList");
					for(int i = 0; i < addAreaList.length; i++) {
						Area area = new Area();
						area.setId(Integer.valueOf(addAreaList[i]));
						addMachine.addArea(area);
					}
					
					boolean verif = ((Employee) user).createMachine(addMachine);
					
					if(verif)
					{	
						response.sendRedirect(request.getContextPath() + "/Machine?siteid=" + idSite + "&areaid=" + idArea + "");
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