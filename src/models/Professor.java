package models;

import enums.Degree;
import enums.Gender;
import enums.Level;
import interfaces.Employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static constants.SalaryConstants.PERCENTAGE_BY_LEVEL;
import static constants.SalaryConstants.PROFESSOR_BASE_SALARY;

public class Professor extends Person implements Employee, Serializable {
    private Level level;
    private Degree degree;
    private List<String> classes;

    public Professor() {
    }

    public Professor(String name, String cpf, LocalDate birthDate,
                     Gender gender, Address address, Long registrationNumber,
                     String department, Integer workload, LocalDate entryDate,
                     Level level, Degree degree, List<String> classes) {
        super(name, cpf, birthDate, gender, address, registrationNumber,
                PROFESSOR_BASE_SALARY, department, workload, entryDate);
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
}
