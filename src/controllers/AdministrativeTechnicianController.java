package controllers;

import database.DatabaseDAO;
import models.AdministrativeTechnician;
import models.Person;

public class AdministrativeTechnicianController {
    private static DatabaseDAO db = DatabaseDAO.getInstance();

    private AdministrativeTechnician findAdminTechByRegistrationNumber(int registrationNumber) {
        for (Person p : db.getEmployees()) {
            if (p instanceof AdministrativeTechnician) {
                return (AdministrativeTechnician) p;
            }
        }
        return null;
    }

    public void createAdministrativeTechnician() {}

    public void listAdministrativeTechnician() {
        System.out.println("====================================");
        System.out.println("TÉCNICOS ADMINISTRATIVOS CADASTRADOS");
        System.out.println("====================================");

        for (Person p : db.getEmployees()) {
            if (p instanceof AdministrativeTechnician adminTech) {
                System.out.println(
                        adminTech.getName() + " - " + adminTech.getDepartment()
                );
            }
        }

        System.out.println("====================================");
    }

    public void deleteAdministrativeTechnician(int registrationNumber) {
        AdministrativeTechnician adminTech = findAdminTechByRegistrationNumber(registrationNumber);

        if (adminTech == null) {
            System.out.println("Técnico Administrativo não encontrado.");
            return;
        }

        db.getEmployees().remove(adminTech);
    }

    public void searchAdministrativeTechnician(int registrationNumber) {
        AdministrativeTechnician adminTech = findAdminTechByRegistrationNumber(registrationNumber);

        if (adminTech == null) {
            System.out.println("Técnico Administrativo não encontrado.");
            return;
        }

        System.out.println(adminTech);
    }
}
