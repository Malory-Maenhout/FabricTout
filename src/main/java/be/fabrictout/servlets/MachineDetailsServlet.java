package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.enums.StatusMachineEnum;
import be.fabrictout.javabeans.*;

/**
 * Servlet implementation class MachineDetailsServlet
 */
public class MachineDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachineDetailsServlet() {
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
					//Data recovery
					int idMachine = Integer.valueOf(request.getParameter("machineid"));
					Machine machineDetails = Machine.getMachine(idMachine);
					request.setAttribute("machineDetails", machineDetails);
					
					if(user.getDiscriminator().equals("EMPLOYE"))
					{
						//Data recovery
						int idSite = Integer.valueOf(request.getParameter("siteid"));
						request.setAttribute("idSite", idSite);
						int idArea  = Integer.valueOf(request.getParameter("areaid"));
						request.setAttribute("idArea", idArea);
					}
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/MachineDetails.jsp").forward(request, response);
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
					//recovery of a machine to update it
					int idMachine = Integer.valueOf(request.getParameter("machineid"));	
					
					Machine updateMachine = Machine.getMachine(idMachine);
					
					String status = request.getParameter("txtStatus");
					
					switch(status) {
						case "Start" -> updateMachine.setStatus(StatusMachineEnum.Start);
						case "Stop" -> updateMachine.setStatus(StatusMachineEnum.Stop);
						case "Wait" -> updateMachine.setStatus(StatusMachineEnum.Wait);
						default -> updateMachine.setStatus(StatusMachineEnum.Start);
					};
					
					boolean verif = ((Manager) user).updateMachine(updateMachine);
					
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