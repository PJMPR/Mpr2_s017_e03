package dao.repositories;

import java.util.List;

import domain.model.Person;
import domain.model.Wallet;

public interface IWalletRepository extends IRepository<Wallet>{

	public List<Wallet> byPerson(Person person);
}
