package be.fabrictout.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.fabrictout.javabeans.User;

/**
 * Servlet implementation class ErrorServlet
 */
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorServlet() {
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
				//return the good jsp in function of error
				String error = (String) session.getAttribute("error");
				
				switch(error)
				{
					case "400" :
						getServletContext().getRequestDispatcher("/WEB-INF/jsp/400BadRequest.jsp").forward(request, response);
						break;
					case "403" :
						getServletContext().getRequestDispatcher("/WEB-INF/jsp/403Forbidden.jsp").forward(request, response);
						break;
					case "404" :
						getServletContext().getRequestDispatcher("/WEB-INF/jsp/404NotFound.jsp").forward(request, response);
						break;
					case "500" :
						getServletContext().getRequestDispatcher("/WEB-INF/jsp/500ErrorServer.jsp").forward(request, response);
						break;
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