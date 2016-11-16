package dao.mappers;

import domain.model.History;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by L on 16.11.2016.
 */
public class HistoryMapper implements IMapResultSetIntoEntity {
    public History map(ResultSet rs) throws SQLException {
        History history = new History();
        history.setId(rs.getInt("id"));
        history.setDate(rs.getDate("date"));
        history.setAmount(rs.getFloat("amount"));
        history.setRate(rs.getDouble("rate"));
        history.setFromWalletId(rs.getInt("WALLET_FROM_ID"));
        history.setToWalletId(rs.getInt("WALLET_TO_ID"));
        history.setOperationId(rs.getInt("OPERATION_ID"));

        return history;
    }
}
