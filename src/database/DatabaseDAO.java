package database;

import models.Person;

import java.util.ArrayList;

public class DatabaseDAO {
    private ArrayList<Person> employees;
    private static DatabaseDAO db;

    private DatabaseDAO() {
        this.employees = new ArrayList<>();
    }

    public static DatabaseDAO getInstance() {
        if (db == null) {
            db = new DatabaseDAO();
        }
        return db;
    }

    public ArrayList<Person> getEmployees() {
        return employees;
    }
}
