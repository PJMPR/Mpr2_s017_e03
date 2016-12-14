package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TemporaryCurrencyEnumHelper;


@WebServlet("/Test")
public class Test extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		TemporaryCurrencyEnumHelper helper = new TemporaryCurrencyEnumHelper();
		
		String insertEnums = request.getParameter("initEnum");
		if(insertEnums!=null)
			helper.insertCurrencyEnums();
		
		
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		
		if(name!=null&&!name.equals(""))
			session.setAttribute("name", name);
		
		response.setContentType("text/html");

		response.getWriter().println("<h1>Hello "
				+ name
				+ "</h1>"
				+ "<br />"
				+ "<h1>Hello From session"
				+ session.getAttribute("name")
				+ "</h1>");

		response.sendRedirect("/addPerson.html");
	}

}
