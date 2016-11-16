package dao.mappers;

import java.sql.ResultSet;

public interface IMapResultSetIntoEntity<TEntity> {

	public TEntity map(ResultSet rs);
	
}
