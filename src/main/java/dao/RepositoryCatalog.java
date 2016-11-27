package dao;

import dao.mappers.EnumDictionaryMapper;
import dao.mappers.HistoryMapper;
import dao.mappers.PersonMapper;
import dao.mappers.WalletMapper;
import dao.repositories.*;
import dao.uow.IUnitOfWork;

import java.sql.Connection;

/**
 * @author L on 27.11.2016.
 */
public class RepositoryCatalog implements IRepositoryCatalog {

    private Connection connection;
    private IUnitOfWork uow;

    public RepositoryCatalog(Connection connection, IUnitOfWork uow) {
        super();
        this.connection = connection;
        this.uow = uow;
    }

    @Override
    public IPersonRepository People() {
        return new PersonRepository(connection, new PersonMapper(), uow);
    }

    @Override
    public IEnumDictionariesRepository Dictionaries() {
        return new EnumDictionaryRepository(connection, new EnumDictionaryMapper(), uow);
    }

    @Override
    public IHistoryRepository WallettHistory() {
        return new HistoryRepository(connection, new HistoryMapper(), uow);
    }

    @Override
    public IWalletRepository Wallets() {
        return new WalletRepository(connection, new WalletMapper(), uow);
    }

    @Override
    public void save() {
        uow.saveChanges();
    }
}
