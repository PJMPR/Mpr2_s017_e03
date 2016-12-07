package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.ContentType;

@WebServlet("/Test")
public class Test extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		response.setContentType("text/html");
		
		response.getWriter().println("<h1>Hello "
				+ name
				+ "</h1>");
		
	}

}
