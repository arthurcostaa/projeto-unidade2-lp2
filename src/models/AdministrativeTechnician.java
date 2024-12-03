package models;

import com.sun.source.tree.ReturnTree;
import enums.Degree;
import enums.Gender;
import enums.Level;
import interfaces.Employee;

import java.time.LocalDate;

public class AdministrativeTechnician extends Person implements Employee {
    private Level level;
    private Degree degree;
    private Boolean unhealthiness;
    private Boolean bonusPosition;

    public AdministrativeTechnician(String name, String cpf,
                                    LocalDate dateOfBirth, Gender gender,
                                    Address address, Long registrationNumber,
                                    Double salary, String department,
                                    Integer workload, LocalDate entryDate,
                                    Level level, Degree degree,
                                    Boolean unhealthiness,
                                    Boolean bonusPosition) {
        super(name, cpf, dateOfBirth, gender, address, registrationNumber,
                salary, department, workload, entryDate);
        this.level = level;
        this.degree = degree;
        this.unhealthiness = unhealthiness;
        this.bonusPosition = bonusPosition;
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

    public Boolean getUnhealthiness() {
        return unhealthiness;
    }

    public void setUnhealthiness(Boolean unhealthiness) {
        this.unhealthiness = unhealthiness;
    }

    public Boolean getBonusPosition() {
        return bonusPosition;
    }

    public void setBonusPosition(Boolean bonusPosition) {
        this.bonusPosition = bonusPosition;
    }

    @Override
    public Double calculateSalary() {
        final double BASE_SALARY = 2500;
        double salary = BASE_SALARY;

        salary = BASE_SALARY * Math.pow(1.05, level.getLevel());

        switch (degree) {
            case Degree.SPECIALIZATION:
                salary += BASE_SALARY * 0.25;
                break;
            case Degree.MASTER:
                salary += BASE_SALARY * 0.5;
                break;
            case Degree.DOCTORATE:
                salary += BASE_SALARY * 0.75;
                break;
        }

        if (unhealthiness) {
            salary += BASE_SALARY * 0.5;
        }

        if (bonusPosition) {
            salary += BASE_SALARY * 0.5;
        }

        return salary;
    }
}
