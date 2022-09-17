package com.example.employeepayroll.dto;

public class EmployeeDTO {

    String firstName;
    String lastName;
    String gender;
    String department;
    long empSalary;
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

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }


}
