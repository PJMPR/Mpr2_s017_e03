package dao;

import dao.mappers.EnumDictionaryMapper;
import dao.mappers.HistoryMapper;
import dao.mappers.PersonMapper;
import dao.mappers.WalletMapper;
import dao.repositories.*;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryCatalog implements IRepositoryCatalog {

    private IUnitOfWork uow;
    private Connection connection;

    private EnumDictionaryRepository enumRepo;
    private HistoryRepository historyRepo;
    private PersonRepository personRepo;
    private WalletRepository walletRepo;

    public RepositoryCatalog(String connectionString) throws SQLException {

        setConnection(getNewConnection(connectionString));
        setUow(getNewUow());

    }
    
    public IPersonRepository People() {
        if (personRepo == null) {
            personRepo = new PersonRepository(connection, new PersonMapper(), uow);
        }
        return personRepo;
    }

    public IEnumDictionariesRepository Dictionaries() {
        if (enumRepo == null) {
            enumRepo = new EnumDictionaryRepository(connection,
                    new EnumDictionaryMapper(), uow);
        }
        return enumRepo;
    }

    public IHistoryRepository WallettHistory() {
        if (historyRepo == null) {
            historyRepo = new HistoryRepository(connection, new HistoryMapper(), uow);
        }
        return historyRepo;
    }

    public IWalletRepository Wallets() {
        if (walletRepo != null) {
            walletRepo = new WalletRepository(connection, new WalletMapper(), uow);
        }
        return walletRepo;
    }

    public void saveAndClose() {
        uow.saveChanges();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getNewConnection(String connectionString) throws SQLException {

        return DriverManager.getConnection(connectionString);
    }

    private IUnitOfWork getNewUow() {
        return new UnitOfWork(connection);
    }

    private void setUow(IUnitOfWork uow) {
        this.uow = uow;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

}
