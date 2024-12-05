package controllers;

import database.DatabaseDAO;
import models.Person;
import models.Professor;

public class ProfessorController {
    public static DatabaseDAO db = DatabaseDAO.getInstance();

    private Professor findProfessorByRegistrationNumber(int registrationNumber) {
        for (Person p : db.getEmployees()) {
            if (p instanceof Professor) {
                return (Professor) p;
            }
        }
        return null;
    }

    public void createProfessor() {}

    public void listProfessor() {
        System.out.println("=======================");
        System.out.println("PROFESSORES CADASTRADOS");
        System.out.println("=======================");

        for (Person p : db.getEmployees()) {
            if (p instanceof Professor) {
                System.out.println(p);
            }
        }
        System.out.println("=======================");
    }

    public void deleteProfessor(int registrationNumber) {
        Professor prof = findProfessorByRegistrationNumber(registrationNumber);

        if (prof == null) {
            System.out.println("Professor não encontrado.");
        }

        db.getEmployees().remove(prof);
    }

    public void searchProfessor(int registrationNumber) {
        Professor prof = findProfessorByRegistrationNumber(registrationNumber);

        if (prof == null) {
            System.out.println("Professor não encontrado.");
        }

        System.out.println(prof);
    }
}
