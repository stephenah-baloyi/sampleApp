package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/loginServlet.jsp").forward(request, response);
	}	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//email=test@test.com password=test
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		
		if(email.equalsIgnoreCase("test@test.com") && password.equalsIgnoreCase("test"))
		{
			request.getRequestDispatcher("/WEB-INF/views/success.jsp").
			forward(request, response);
		}
		else{
			
			request.setAttribute("error", "Invalid User/Password");
			request.getRequestDispatcher("/WEB-INF/views/loginServlet.jsp").
			forward(request, response);
		}
	}

}
