import controllers.AdministrativeTechnicianController;
import controllers.ProfessorController;

import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("1. Cadastrar professor");
        System.out.println("2. Cadastrar técnico administrativo");
        System.out.println("3. Listar professores");
        System.out.println("4. Listar técnico administrativo");
        System.out.println("5. Apagar professor");
        System.out.println("6. Apagar técnico administrativo");
        System.out.println("7. Procurar professor por matrícula");
        System.out.println("8. Procurar técnico administrativo por matrícula");
        System.out.println("9. Cálcular salário do professor");
        System.out.println("10. Cálcular salário do técnico administrativo");
        System.out.println("0. Encerrar programa");
        System.out.println("Digite a opção escolhida:");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            int answer = scan.nextInt();

            switch (answer) {
                case 0:
                    running = false;
                    break;
                case 1:
                    ProfessorController.createProfessor();
                    break;
                case 2:
                    AdministrativeTechnicianController.createAdministrativeTechnician();
                    break;
                case 3:
                    ProfessorController.listProfessors();
                    break;
                case 4:
                    AdministrativeTechnicianController.listAdministrativeTechnician();
                    break;
                case 5:
                    ProfessorController.deleteProfessor();
                    break;
                case 6:
                    AdministrativeTechnicianController.deleteAdministrativeTechnician();
                    break;
                case 7:
                    ProfessorController.searchProfessor();
                    break;
                case 8:
                    AdministrativeTechnicianController.searchAdministrativeTechnician();
                    break;
                case 9:
                    ProfessorController.calculateSalaryProfessor();
                    break;
                case 10:
                    AdministrativeTechnicianController.calculateSalaryAdministrativeTechnician();
                    break;
                default:
                    System.out.println("Opção inválida. Tenten novamente.");
                    break;
            }
        }
    }
}
