package domain;

import dao.*;
import dao.repositories.IRepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class App {
    public static void main(String[] args) {
       
    	Connection connection;
		try {
			connection = DriverManager.getConnection("");
	    	IRepositoryCatalog catalogOf = 
	    			new RepositoryCatalog(connection, new UnitOfWork(connection));
	    	
	    	List<Person> people =  catalogOf.People().withName("janek");
	    	
	    	catalogOf.Dictionaries().withDictionaryName("gender");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
