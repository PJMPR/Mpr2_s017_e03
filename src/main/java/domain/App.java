package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.PersonRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			Connection connection = 
					DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			PersonRepository repo = new PersonRepository(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
