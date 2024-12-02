package models;

import enums.Degree;
import enums.Gender;
import enums.Level;
import interfaces.Employee;

import java.time.LocalDate;
import java.util.List;

public class Professor extends Person implements Employee {
    private Level level;
    private Degree degree;
    private List<String> classes;

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
        return null;
    }
}
