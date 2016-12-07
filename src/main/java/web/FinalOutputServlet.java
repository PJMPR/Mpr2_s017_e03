package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/final")
public class FinalOutputServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String currencyName = (String) session.getAttribute("currency");
        String personName = (String) session.getAttribute("name");

        resp.setContentType("text/html");

        resp.getWriter().println("<h1> Pan " + personName + " wybrał walutę.<br>"
                + " Wybrana waluta :"
                + currencyName + "</br></h1>");

    }

}
