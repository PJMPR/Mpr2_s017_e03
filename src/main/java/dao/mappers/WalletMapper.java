package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Person;
import domain.model.Wallet;

public class WalletMapper implements IMapResultSetIntoEntity<Wallet>{

	public Wallet map(ResultSet rs) throws SQLException {
		Wallet wallet = new Wallet();
		wallet.setId(rs.getInt("id"));
		wallet.setAccountID(rs.getInt("accountID"));
		wallet.setAsset(rs.getBigDecimal("asset"));
		return wallet;
	}

}
