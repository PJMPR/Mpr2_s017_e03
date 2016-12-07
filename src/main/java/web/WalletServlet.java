package web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/walletServlet")
public class WalletServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("currency");
        Integer value = Integer.parseInt(req.getParameter("value"));
        resp.setContentType("text/html");

        resp.getWriter().println("<h1>Hello <br>"
                + " Wybrales walute :"
                + name +"</br>"
                + "o wartosci :"
                + value + "</br>"
                + "</h1>");
    }

}
