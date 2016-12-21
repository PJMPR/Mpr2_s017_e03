package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Person;

@WebServlet("/personServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
			throws ServletException, IOException {

		Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setSurname(request.getParameter("surname"));
		HttpSession session = request.getSession();
		if (person==session.getAttribute("person")){
			response.sendRedirect("/addWallet.html");
		}
		else{
			session.setAttribute("person", person);
			response.sendRedirect("/addWallet.html");
		}
	}
}
