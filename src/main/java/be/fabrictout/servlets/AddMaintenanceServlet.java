package be.fabrictout.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class AddMaintenance
 */
public class AddMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMaintenanceServlet() {
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
				if(user.getDiscriminator().equals("MANAGER"))
				{	
					//Recovery data and return to the jsp
					Manager manager = (Manager) user;
					List<Worker> workerList = manager.getWorkerList();					
					request.setAttribute("workerList", workerList);
					
					int idMachine = Integer.valueOf(request.getParameter("machineid"));
					request.setAttribute("idMachine", idMachine);
										
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddMaintenance.jsp").forward(request, response);
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
				if(user.getDiscriminator().equals("MANAGER"))
				{	
					//Data retrieval to create an maintenance
					int idMachine = Integer.valueOf(request.getParameter("idMachine"));
					
					Date Date = java.sql.Date.valueOf(request.getParameter("txtDate"));
					int Duration = Integer.valueOf(request.getParameter("txtDuration"));
					String Status = "ToDo";
					
					Maintenance addMaintenance = new Maintenance(Date, Duration, Status);
					
					String[] addWorkerList = request.getParameterValues("txtWorkerList");
					
					for(int i = 0; i < addWorkerList.length; i++) {
						Worker worker = new Worker();
						worker.setId(Integer.valueOf(addWorkerList[i]));
						addMaintenance.addWorker(worker);
					}
					
					Machine machine = new Machine();
					machine.setId(idMachine);
					
					addMaintenance.setMachine(machine);
					
					boolean verif = ((Manager) user).createMaintenance(user.getId(), addMaintenance);
					
					if(verif)
					{	
						response.sendRedirect(request.getContextPath() + "/MachineDetails?machineid=" + idMachine + "");
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