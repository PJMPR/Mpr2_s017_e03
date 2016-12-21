package web;

import domain.model.Currency;
import domain.model.Person;
import domain.model.Wallet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        BigDecimal value = new BigDecimal(req.getParameter("value"));
        HttpSession session = req.getSession();
        Person person = (Person) session.getAttribute("person");
        if(person==null)
        { 
	        resp.sendRedirect("/addPerson.html");
        }
        Wallet wallet = new Wallet();
        wallet.setCurrency(Currency.valueOf(name));
        wallet.setAsset(value);
        wallet.setPerson(person);
        List<Wallet> wallets = (List<Wallet>) session.getAttribute("wallets");
    	if(wallets == null)
    	{
            wallets = new ArrayList<Wallet>();
            wallets.add(wallet);
    	}
    	else 
    	{
    		wallets.add(wallet);
    	}
        session.setAttribute("wallets",wallets);
        resp.sendRedirect("/final.jsp");
    }

}
