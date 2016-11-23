package domain;

import dao.*;
import dao.repositories.IRepositoryCatalog;
import domain.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class App {
    public static void main(String[] args) {
       
    	IRepositoryCatalog catalogOf;
    	
    	List<Person> people =  catalogOf.People().withName("janek");
    	
    	catalogOf.Dictionaries().withDictionaryName("gender");
    }
}
