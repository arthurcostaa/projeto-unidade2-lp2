package controllers;

import database.DatabaseDAO;
import models.Person;
import models.Professor;
import utils.InputReader;

import java.util.Scanner;

public class ProfessorController {
    private static DatabaseDAO db = DatabaseDAO.getInstance();
    private static Scanner scan = new Scanner(System.in);

    private static Professor findProfessorByRegistrationNumber(int registrationNumber) {
        for (Person p : db.getEmployees()) {
            if (p instanceof Professor) {
                if (((Professor) p).getRegistrationNumber() == registrationNumber) {
                    return (Professor) p;
                }
            }
        }
        return null;
    }

    public static void createProfessor() {
        Professor prof = new Professor();

        InputReader.readPersonalInfo(prof);
        prof.setAddress(InputReader.readAddress());
        InputReader.readWorkInfo(prof);
        InputReader.readProfessorClasses(prof);
        prof.setDegree(InputReader.readDegree());
        db.getEmployees().add(prof);

        System.out.println("Professor cadastrado com sucesso.");
    }

    public static void listProfessors() {
        System.out.println("=======================");
        System.out.println("PROFESSORES CADASTRADOS");
        System.out.println("=======================");

        for (Person p : db.getEmployees()) {
            if (p instanceof Professor prof) {
                System.out.println(prof.getName());
                System.out.println("\tDISCIPLINAS MINISTRADAS\n");
                for (String classes : prof.getClasses()) {
                    System.out.println("\t" + classes);
                }
                System.out.println();
            }
        }

        System.out.println("=======================");
    }

    public static void deleteProfessor(int registrationNumber) {
        Professor prof = findProfessorByRegistrationNumber(registrationNumber);

        if (prof == null) {
            System.out.println("Professor não encontrado.");
        }

        db.getEmployees().remove(prof);
    }

    public static void searchProfessor(int registrationNumber) {
        Professor prof = findProfessorByRegistrationNumber(registrationNumber);

        if (prof == null) {
            System.out.println("Professor não encontrado.");
        }

        System.out.println(prof);
    }
}
