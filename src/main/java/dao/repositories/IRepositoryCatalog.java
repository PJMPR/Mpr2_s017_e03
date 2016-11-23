package dao.repositories;

public interface IRepositoryCatalog {

	public IPersonRepository People();
	public IEnumDictionariesRepository Dictionaries();
	public IHistoryRepository WallettHistory();
	public IWalletRepository Wallets();
}
