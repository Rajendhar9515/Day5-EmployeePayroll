package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeeDTO;

import javax.persistence.*;

@Entity
public class EmployeeDetails {

    String firstName;
    String lastName;
    String gender;
    String department;
    long empSalary;

    public EmployeeDetails(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.department = employeeDTO.getDepartment();
        this.gender = employeeDTO.getGender();
        this.id = id;
        this.empSalary = employeeDTO.getEmpSalary();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public EmployeeDetails(EmployeeDetails employeeDetails){
        this.firstName = employeeDetails.firstName;
        this.lastName = employeeDetails.lastName;
        this.department = employeeDetails.department;
        this.gender = employeeDetails.gender;
        this.id = employeeDetails.id;
        this.empSalary = employeeDetails.empSalary;
    }

    public EmployeeDetails(String message) {
        this.message = message;

    }

    public EmployeeDetails(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }


}
