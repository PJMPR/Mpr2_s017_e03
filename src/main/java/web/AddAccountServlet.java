package web;

import java.io.IOException;
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
			
		
	HttpSession session = req.getSession();
	Wallet wallet = new Wallet();
	wallet.setCurrency((Currency) session.getAttribute("currency"));
	wallet.setAsset( (BigDecimal) session.getAttribute("value"));
	wallet.setPerson((Person) session.getAttribute(SessionKey.person));
	
	
	
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

	resp.sendRedirect("/addWallet.html");
}
}