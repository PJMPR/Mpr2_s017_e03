package dao.repositories;

import java.util.Date;
import java.util.List;

import domain.model.History;
import domain.model.Operation;
import domain.model.Wallet;

public interface IHistoryRepository extends IRepository<History>{
	
	public List<History> of(Wallet wallet);
	public List<History> ofType(Operation operation);
	public List<History> withDate(Date from, Date to);

}
