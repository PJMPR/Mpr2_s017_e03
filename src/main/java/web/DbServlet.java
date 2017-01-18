package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Person;
import domain.model.Wallet;

@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DbServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		try {
			IRepositoryCatalog catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
			HttpSession session = request.getSession();
			Person person = (Person) session.getAttribute("person");
			List<Wallet> wallets = (List<Wallet>) session.getAttribute("wallets");
			catalog.People().add(person);
			catalog.save();
			int personId = catalog.People().getLastId();
			person.setId(personId);
			for(Wallet wallet: wallets){
				wallet.setPerson(person);
				catalog.Wallets().add(wallet);
			}
			catalog.saveAndClose();
			session.removeAttribute("person");
			session.removeAttribute("wallets");
			response.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
