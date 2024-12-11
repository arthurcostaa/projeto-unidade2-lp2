package controllers;

import database.DatabaseDAO;
import models.Person;
import models.Professor;

public class ProfessorController {
    private static DatabaseDAO db = DatabaseDAO.getInstance();

    private Professor findProfessorByRegistrationNumber(int registrationNumber) {
        for (Person p : db.getEmployees()) {
            if (p instanceof Professor) {
                return (Professor) p;
            }
        }
        return null;
    }

    public void createProfessor() {}

    public void listProfessors() {
        System.out.println("=======================");
        System.out.println("PROFESSORES CADASTRADOS");
        System.out.println("=======================");

        for (Person p : db.getEmployees()) {
            if (p instanceof Professor prof) {
                System.out.println(prof.getName());
                System.out.println("DISCIPLINAS MINISTRADAS\n");
                for (String classes : prof.getClasses()) {
                    System.out.println(classes);
                }
                System.out.println();
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
