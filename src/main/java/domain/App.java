package domain;

import dao.*;

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
