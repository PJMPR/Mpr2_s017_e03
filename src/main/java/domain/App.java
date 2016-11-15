package domain;

import dao.*;
import domain.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) {
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            PersonRepository personRepository = new PersonRepository(connection);
            CurrencyRepository currencyRepository = new CurrencyRepository(connection);
            OperationRepository operationRepository = new OperationRepository(connection);
            WalletRepository walletRepository = new WalletRepository(connection);
            HistoryRepository historyRepository = new HistoryRepository(connection);
            
            Person janek = new Person();
            janek.setName("janek");
            janek.setSurname("kowalski");
            //spersonRepository.add(janek);
            Person janekFromDb = personRepository.get(0);
            System.out.println(janekFromDb.getName() + " " + janekFromDb.getSurname());
            System.out.print("End");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
