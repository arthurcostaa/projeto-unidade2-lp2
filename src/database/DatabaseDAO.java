package database;

import models.Person;

import java.io.*;
import java.util.ArrayList;

public class DatabaseDAO implements Serializable {
    private ArrayList<Person> employees;
    private static DatabaseDAO db;
    private final String FILE_NAME = "./src/assets/database.db";

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
        return this.employees;
    }

    public void saveData() {
        try {
            FileOutputStream outputFile = new FileOutputStream(FILE_NAME);
            ObjectOutputStream output = new ObjectOutputStream(outputFile);
            output.writeObject(employees);
            output.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo.");
        }
    }

    @SuppressWarnings("unchecked")
    public void readData() {
        try {
            FileInputStream inputFile = new FileInputStream(FILE_NAME);
            ObjectInputStream input = new ObjectInputStream(inputFile);
            this.employees = (ArrayList<Person>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler dados do sistema.");
        }
    }
}
