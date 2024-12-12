package controllers;

import database.DatabaseDAO;
import models.AdministrativeTechnician;
import models.Person;
import utils.InputReader;

import java.util.Scanner;

public class AdministrativeTechnicianController {
    private static DatabaseDAO db = DatabaseDAO.getInstance();
    private static Scanner scan = new Scanner(System.in);

    private static AdministrativeTechnician findAdminTechByRegistrationNumber(int registrationNumber) {
        for (Person p : db.getEmployees()) {
            if (p instanceof AdministrativeTechnician) {
                if (((AdministrativeTechnician) p).getRegistrationNumber() == registrationNumber) {
                    return (AdministrativeTechnician) p;
                }
            }
        }
        return null;
    }

    public static void createAdministrativeTechnician() {
        AdministrativeTechnician adminTech = new AdministrativeTechnician();

        InputReader.readPersonalInfo(adminTech);
        adminTech.setAddress(InputReader.readAddress());
        InputReader.readWorkInfo(adminTech);
        adminTech.setDegree(InputReader.readDegree());
        adminTech.setUnhealthiness(InputReader.readYesNoQuestion("Insalubridade (S/N):"));
        adminTech.setBonusPosition(InputReader.readYesNoQuestion("Função gratificada (S/N):"));

        db.getEmployees().add(adminTech);
        System.out.println("Técnico administrativo cadastrado com sucesso.");
    }

    public static void listAdministrativeTechnician() {
        System.out.println("====================================");
        System.out.println("TÉCNICOS ADMINISTRATIVOS CADASTRADOS");
        System.out.println("====================================");

        for (Person p : db.getEmployees()) {
            if (p instanceof AdministrativeTechnician adminTech) {
                System.out.println(adminTech);
            }
        }

        System.out.println("====================================");
    }

    public static void deleteAdministrativeTechnician() {
        System.out.println("Código do técnico administrativo:");
        int registrationNumber = scan.nextInt();

        AdministrativeTechnician adminTech = findAdminTechByRegistrationNumber(registrationNumber);

        if (adminTech == null) {
            System.out.println("Técnico Administrativo não encontrado.");
            return;
        }

        db.getEmployees().remove(adminTech);
    }

    public static void searchAdministrativeTechnician() {
        System.out.println("Código do técnico administrativo:");
        int registrationNumber = scan.nextInt();

        AdministrativeTechnician adminTech = findAdminTechByRegistrationNumber(registrationNumber);

        if (adminTech == null) {
            System.out.println("Técnico Administrativo não encontrado.");
            return;
        }

        System.out.println(adminTech);
    }

    public static void calculateSalaryAdministrativeTechnician() {
        System.out.println("Código do técnico administrativo:");
        int registrationNumber = scan.nextInt();

        AdministrativeTechnician adminTech = findAdminTechByRegistrationNumber(registrationNumber);

        if (adminTech == null) {
            System.out.println("Técnico Administrativo não encontrado.");
            return;
        }

        System.out.println("O salário do técnico administrativo é " + adminTech.calculateSalary());
    }
}
