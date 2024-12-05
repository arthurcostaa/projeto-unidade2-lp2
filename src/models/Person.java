package models;

import enums.Gender;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Address address;
    private Long registrationNumber;
    private Double salary;
    private String department;
    private Integer workload;
    private LocalDate entryDate;

    public Person() {
    }

    public Person(String name, String cpf, LocalDate dateOfBirth,
                  Gender gender, Address address, Long registrationNumber,
                  Double salary, String department, Integer workload,
                  LocalDate entryDate) {
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.salary = salary;
        this.department = department;
        this.workload = workload;
        this.entryDate = entryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return name + " - " + cpf + " - " + this.getDepartment();
    }
}
