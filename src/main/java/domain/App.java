package domain;

import dao.PersonRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by L on 26.10.2016.
 */
public class App {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            PersonRepository repository= new PersonRepository(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
