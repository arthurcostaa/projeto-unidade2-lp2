package utils;

import models.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    private static Scanner scan = new Scanner(System.in);

    public static boolean readYesNoQuestion(String prompt) {
        System.out.println(prompt);
        String answer = scan.nextLine();
        return answer.equalsIgnoreCase("S");
    }

    public static LocalDate readDate(String prompt) {
        LocalDate date = LocalDate.now();

        while (true) {
            try {
                System.out.println(prompt);
                return LocalDate.parse(scan.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Erro ao processar a data. Tente novamente.");
            }
        }
    }

    public static Gender readGender() {
        while (true) {
            try {
                System.out.println("Gênero (MASC, FEM, OUTRO):");
                return Gender.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao ler gênero. Tente novamente.");
            }
        }
    }

    public static Degree readDegree() {
        while (true) {
            try {
                System.out.println("Formação (SPECIALIZATION, MASTER, DOCTORATE)");
                return Degree.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao ler formação. Tente novamente.");
            }
        }
    }

    public static Level readLevel() {
        while (true) {
            try {
                System.out.println("Nível (I, II, III, IV, V, VI, VII, VII)");
                return Level.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao ler nível. Tente novamente.");
            }
        }
    }

    public static void readPersonalInfo(Person person) {
        System.out.println("Nome:");
        person.setName(scan.nextLine());
        System.out.println("CPF:");
        person.setCpf(scan.nextLine());
        person.setBirthDate(readDate("Data de nascimento (AAAA-MM-DD)"));
        person.setGender(readGender());
    }

    public static Address readAddress() {
        Address address = new Address();

        System.out.println("Rua:");
        address.setStreet(scan.nextLine());
        System.out.println("Número");
        address.setNumber(scan.nextLine());
        System.out.println("Bairro:");
        address.setNeighborhood(scan.nextLine());
        System.out.println("Cidade:");
        address.setCity(scan.nextLine());
        System.out.println("CEP:");
        address.setCep(scan.nextLine());

        return address;
    }

    public static void readWorkInfo(Person person) {
        System.out.println("Matrícula:");
        person.setRegistrationNumber(scan.nextLong());
        scan.nextLine();
        System.out.println("Departamento:");
        person.setDepartment(scan.nextLine());
        System.out.println("Carga horária:");
        person.setWorkload(scan.nextInt());
        scan.nextLine();
        person.setEntryDate(readDate("Data de entrada (AAAA-MM-DD):"));
    }

    public static void readProfessorClasses(Professor professor) {
        System.out.println("TURMAS DO PROFESSOR");
        String profClass;
        professor.setClasses(new ArrayList<>());
        do {
            System.out.println("Nome da turma (enter para encerrar):");
            profClass = scan.nextLine();
            if (!profClass.isEmpty()) {
                professor.getClasses().add(profClass);
            }
        } while (!profClass.isEmpty());
    }
}