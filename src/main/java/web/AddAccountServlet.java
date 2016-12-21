package web;

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

import domain.model.Currency;
import domain.model.Person;
import domain.model.Wallet;

import java.math.BigDecimal;

@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, 	HttpServletResponse resp)throws ServletException, IOException {
			
	
	
    String name = req.getParameter("currency");
    BigDecimal value = new BigDecimal(req.getParameter("value"));
    HttpSession session = req.getSession();
	  wallet.setPerson((Person) session.getAttribute(SessionKey.person));
    Wallet wallet = new Wallet();
    wallet.setCurrency(Currency.valueOf(name));
    wallet.setAsset(value);
    wallet.setPerson(person);
	
	List<Wallet> wallets = (List<Wallet>) session.getAttribute(SessionKey.wallets);
	if(wallets == null)
	{
		wallets = new ArrayList<Wallet>();
		wallets.add(wallet);
		session.setAttribute(SessionKey.wallets, wallets);
	}
	else
	{
		wallets.add(wallet);
	}
	session.setAttribute("wallets", wallets);
	resp.sendRedirect("/addWallet.html");
}
}