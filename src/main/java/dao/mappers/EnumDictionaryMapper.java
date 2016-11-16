package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.EnumDictionary;

public class EnumDictionaryMapper implements IMapResultSetIntoEntity<EnumDictionary>{

	public EnumDictionary map(ResultSet rs) throws SQLException {
		EnumDictionary enumDictionary = new EnumDictionary();
		enumDictionary.setId(rs.getInt("id"));
		enumDictionary.setIntKey(rs.getInt("intKey"));
		enumDictionary.setStringKey(rs.getString("stringKey"));
		enumDictionary.setValue(rs.getString("value"));
		enumDictionary.setEnumerationName(rs.getString("enumerationName"));
		return enumDictionary;
	}

}
