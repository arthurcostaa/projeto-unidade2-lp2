package models;

import enums.Degree;
import enums.Gender;
import enums.Level;
import interfaces.Employee;

import java.io.Serializable;
import java.time.LocalDate;

import static constants.SalaryConstants.ADMINISTRATIVE_TECHNICIAN_BASE_SALARY;
import static constants.SalaryConstants.PERCENTAGE_BY_LEVEL;

public class AdministrativeTechnician extends Person implements Employee, Serializable {
    private Level level;
    private Degree degree;
    private Boolean unhealthiness;
    private Boolean bonusPosition;

    public AdministrativeTechnician() {
    }

    public AdministrativeTechnician(String name, String cpf,
                                    LocalDate birthDate, Gender gender,
                                    Address address, Long registrationNumber,
                                    String department,
                                    Integer workload, LocalDate entryDate,
                                    Level level, Degree degree,
                                    Boolean unhealthiness,
                                    Boolean bonusPosition) {
        super(name, cpf, birthDate, gender, address, registrationNumber,
                ADMINISTRATIVE_TECHNICIAN_BASE_SALARY,
                department, workload, entryDate);
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
        double salary =
            ADMINISTRATIVE_TECHNICIAN_BASE_SALARY * Math.pow(1 + PERCENTAGE_BY_LEVEL, level.getLevel());
        salary += ADMINISTRATIVE_TECHNICIAN_BASE_SALARY * degree.getDegree();

        if (unhealthiness) {
            salary += ADMINISTRATIVE_TECHNICIAN_BASE_SALARY * 0.5;
        }

        if (bonusPosition) {
            salary += ADMINISTRATIVE_TECHNICIAN_BASE_SALARY * 0.5;
        }

        return salary;
    }
}
