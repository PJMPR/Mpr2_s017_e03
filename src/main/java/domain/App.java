package domain;

import dao.*;
import dao.repositories.IRepositoryCatalog;
import dao.uow.UnitOfWork;
import domain.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static final String CONNECTION_STRING="jdbc:hsqldb:hsql://localhost/workdb";
    
    public static void main(String[] args) {

    }
}
