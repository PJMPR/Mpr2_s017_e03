package web;

import domain.model.Currency;
import domain.model.Person;
import domain.model.Wallet;
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

        
        Person person = (Person) session.getAttribute("person");
        Wallet wallet = (Wallet) session.getAttribute("wallet");

        
        resp.setContentType("text/html");

        resp.getWriter().println("<h1> Pan " + person.getName() + " wybrał walutę.<br>"
                + " Wybrana waluta :"
                + wallet.getCurrency().toString() + "</br></h1>");

    }

}
