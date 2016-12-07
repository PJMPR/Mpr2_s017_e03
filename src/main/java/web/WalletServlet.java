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

@WebServlet("/walletServlet")
public class WalletServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("currency");

        Integer value = Integer.parseInt(req.getParameter("value"));

        
        HttpSession session = req.getSession();

        Wallet wallet = new Wallet();
        wallet.setCurrency(Currency.valueOf(name));
        wallet.setPerson((Person)session.getAttribute("person"));
        
        session.setAttribute("wallet",wallet );
        
        resp.sendRedirect("/final");
    }

}
