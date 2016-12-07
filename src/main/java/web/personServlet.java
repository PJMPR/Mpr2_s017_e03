package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/personServlet")
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		HttpSession session = request.getSession();
		
		if((name!=null&&!name.equals(""))&&(surname!=null&&!surname.equals(""))) {
			session.setAttribute("name", name);
			session.setAttribute("surname", surname);
		}

		response.sendRedirect("/addWallet.html");
		
	}

}
