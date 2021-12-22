package be.fabrictout.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.fabrictout.javabeans.User;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personnelNumberParam = request.getParameter("inputPersonnelNumber");
		String passwordParam = request.getParameter("inputPassword");
		
		ArrayList<String> errors = new ArrayList<String>();
		
		if(personnelNumberParam == null)
		{
			errors.add("This [personnalNumber] is null!");
		}
		else
		{
			if(personnelNumberParam.equals(""))
			{
				errors.add("This parameter [personnelNumber] is empty!");
			}
		}
		
		if(passwordParam == null)
		{
			errors.add("This parameter [password] is null!");
		}
		else
		{
			if(passwordParam.equals(""))
			{
				errors.add("This parameter [password] is empty!");
			}
		}
		
		if(personnelNumberParam != null && passwordParam != null && errors.size()== 0)
		{
			User user = User.login(personnelNumberParam, passwordParam);
			if(user != null)
			{
				HttpSession session = request.getSession();
				if(!session.isNew()) 
				{
						session.invalidate();
						session = request.getSession();			
				}
				session.setAttribute("user", user);	
				response.sendRedirect(request.getContextPath() + "/Home");
			}
			else
			{
				errors.add("This personnel number or password is wrong!");
				request.setAttribute("errors", errors);
				doGet(request, response);
			}
		}
		else
		{
			errors.add("This personnel number or password is wrong!");
			request.setAttribute("errors", errors);
			doGet(request, response);
		}
	}
}
