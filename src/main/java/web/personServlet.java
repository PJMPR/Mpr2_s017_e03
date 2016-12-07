package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class personServlet
 */
@WebServlet("/personServlet")
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		response.setContentType("text/html");
		
		response.getWriter().println("<h1>Hello "
				+ name
				+ " "
				+ surname
				+ "</h1>");
		
	}

}
