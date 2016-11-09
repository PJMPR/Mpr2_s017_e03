package domain;

import dao.*;
import domain.model.Operation;
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

            Person Jan = new Person();
            Jan.setName("Jan");
            Jan.setSurname("Kowalski");
            personRepository.add(Jan);
            Person janFromDb = personRepository.get(0);
            System.out.println(janFromDb.getName() + " " + janFromDb.getSurname());


            operationRepository.add(Operation.income);
            operationRepository.add(Operation.income);
            operationRepository.add(Operation.outcome);
            operationRepository.add(Operation.income);

            System.out.println(operationRepository.get(0));

            operationRepository.delete(40);
            operationRepository.getAll();
            operationRepository.setUpdate(1, Operation.outcome);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
