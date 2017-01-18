package dao.mappers;

import domain.model.History;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by L on 16.11.2016.
 */
public class HistoryMapper implements IMapResultSetIntoEntity<History> {
    public History map(ResultSet rs) throws SQLException {
        History history = new History();
        history.setId(rs.getInt("id"));
        history.setDate(rs.getDate("date"));
        history.setAmount(rs.getDouble("amount"));
        history.setRate(rs.getDouble("rate"));

        return history;
    }
}
