
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
@WebServlet("/walletServlet")
public class WalletServlet extends HttpServlet {

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
