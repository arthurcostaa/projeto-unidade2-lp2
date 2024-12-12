package models;

import constants.SalaryConstants;
import enums.Degree;
import enums.Gender;
import enums.Level;
import interfaces.Employee;

import java.time.LocalDate;
import java.util.List;

import static constants.SalaryConstants.PROFESSOR_BASE_SALARY;
import static constants.SalaryConstants.PERCENTAGE_BY_LEVEL;

public class Professor extends Person implements Employee {
    private Level level;
    private Degree degree;
    private List<String> classes;

    public Professor() {
    }

    public Professor(String name, String cpf, LocalDate dateOfBirth,
                     Gender gender, Address address,
                     Long registrationNumber, String department,
                     Integer workload, LocalDate entryDate) {
        super(name, cpf, dateOfBirth, gender, address, registrationNumber,
                PROFESSOR_BASE_SALARY, department, workload,
                entryDate);
    }

    public Professor(String name, String cpf, LocalDate dateOfBirth,
                     Gender gender, Address address, Long registrationNumber,
                     Double salary, String department, Integer workload,
                     LocalDate entryDate, Level level, Degree degree,
                     List<String> classes) {
        super(name, cpf, dateOfBirth, gender, address, registrationNumber,
                salary, department, workload, entryDate);
        this.level = level;
        this.degree = degree;
        this.classes = classes;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    @Override
    public Double calculateSalary() {
        double salary =
                PROFESSOR_BASE_SALARY * Math.pow(1 + PERCENTAGE_BY_LEVEL,
                        level.getLevel());
        salary += PROFESSOR_BASE_SALARY * degree.getDegree();

        return salary;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getRegistrationNumber();
    }
}
