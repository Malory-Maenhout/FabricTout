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
 * Servlet implementation class AddReportServlet
 */
public class AddReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReportServlet() {
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
				if(user.getDiscriminator().equals("WORKER"))
				{
					//Recovery data and return to the jsp
					int idMaintenance = Integer.valueOf(request.getParameter("maintenanceid"));
					request.setAttribute("idMaintenance", idMaintenance);
					
					Worker worker = (Worker) session.getAttribute("user");
					request.setAttribute("Firstname", worker.getFirstname());
					request.setAttribute("Lastname", worker.getLastname());
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddReport.jsp").forward(request, response);
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
				if(user.getDiscriminator().equals("WORKER"))
				{	
					//Data retrieval to create a report
					int idMaintenance  = Integer.valueOf(request.getParameter("idMaintenance"));
					
					Worker worker = new Worker();
					worker.setId(user.getId());
					String description = request.getParameter("txtDescription");
					description = description.replace("'", " ");
					description = description.replace("\"", " ");
					Date date = Date.valueOf(request.getParameter("txtDate"));
						
					Report addReport = new Report(worker, description, date);
					
					boolean verif = ((Worker) user).createReport(idMaintenance, addReport);					
					
					if(verif)
					{	
						response.sendRedirect(request.getContextPath() + "/MaintenanceDetails?maintenanceid=" + idMaintenance + "");
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