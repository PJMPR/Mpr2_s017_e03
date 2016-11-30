package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IPersonRepository;
import dao.uow.IUnitOfWork;
import domain.model.Person;

public class PersonRepository extends RepositoryBase<Person>
implements IPersonRepository{

    private PreparedStatement getName;
    private PreparedStatement getSurname;

	public PersonRepository(Connection connection,
			IMapResultSetIntoEntity<Person> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);

		try{
		    getName = connection.prepareStatement(getNameSql());
		    getSurname = connection.prepareStatement(getSurnameSql());
        }catch(SQLException e){
		    e.printStackTrace();
        }

	}
	
	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE people("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "name varchar(20)," + "surname varchar(50)" + ")";
	}

	@Override
	protected String tableName() {
		return "people";
	}

	protected String insertSql() {
		return "INSERT INTO people(name, surname) VALUES (?,?)";
	}

	protected String updateSql() {
		return "UPDATE people SET (name, surname)=(?,?) WHERE id=?";
	}

	protected String getNameSql(){return "SELECT * FROM people where name = ?";}
	protected String getSurnameSql(){return "SELECT * FROM people where surName=?";}


	@Override
	protected void setUpdate(Person entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getSurname());
		
	}

	@Override
	protected void setInsert(Person entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getSurname());
	}

    public List<Person> withName(String name) {
    	 List<Person> people = new ArrayList<Person>();
         try{
             getName.setString(1,name);
             ResultSet resultSet = getName.executeQuery();
             while(resultSet.next()){
                 people.add(mapper.map(resultSet));
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return people;
    }


    public List<Person> withSurname(String surname) {
    	 List<Person> people = new ArrayList<Person>();
         try{
             getSurname.setString(1,surname);
             ResultSet resultSet = getSurname.executeQuery();
             while(resultSet.next()){
                 people.add(mapper.map(resultSet));
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return people;
    }

}
