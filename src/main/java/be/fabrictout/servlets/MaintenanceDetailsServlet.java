package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.enums.StatusEnum;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class MaintenanceDetailsServlet
 */
public class MaintenanceDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintenanceDetailsServlet() {
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
				if(user.getDiscriminator().equals("WORKER") || user.getDiscriminator().equals("MANAGER"))
				{
					//Recovery data and return to the jsp
					int idMaintenance = Integer.valueOf(request.getParameter("maintenanceid"));				
					Maintenance maintenanceDetails = Maintenance.getMaintenance(idMaintenance);
					request.setAttribute("maintenanceDetails", maintenanceDetails);
					
					if(user.getDiscriminator().equals("MANAGER"))
					{
						int idMachine = Integer.valueOf(request.getParameter("machineid"));
						request.setAttribute("idMachine", idMachine);
					}
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/MaintenanceDetails.jsp").forward(request, response);
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
				if(user.getDiscriminator().equals("MANAGER"))
				{
					//Recovery of maintenance to update it
					int idMaintenance = Integer.valueOf(request.getParameter("maintenanceid"));				
					Maintenance updateMaintenance = Maintenance.getMaintenance(idMaintenance);
					
					String status = request.getParameter("txtStatusM");
					
					switch(status) {
						case "Do" -> updateMaintenance.setStatus(StatusEnum.Do);
						case "ToDo" -> updateMaintenance.setStatus(StatusEnum.ToDo);
						case "InValidate" -> updateMaintenance.setStatus(StatusEnum.InValidate);
						case "Validate" -> updateMaintenance.setStatus(StatusEnum.Validate);
						default -> updateMaintenance.setStatus(StatusEnum.Do);
					};
					
					boolean verif = ((Manager) user).updateMaintenance(updateMaintenance);
					
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