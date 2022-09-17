package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.model.EmployeeDetails;
import com.example.employeepayroll.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeeInterface {

    @Autowired
    EmployeeRepo employeeRepo;



    public List<EmployeeDetails> display() {
        return employeeRepo.findAll();
    }

    public EmployeeDetails saveAll(EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetails = new EmployeeDetails(employeeDTO);
        return employeeRepo.save(employeeDetails);
    }

    public EmployeeDetails update(EmployeeDetails employeeDetails, int id){
        EmployeeDetails empData = employeeRepo.findById(id).get();
        if(employeeRepo.findById(id).isPresent()) {
            empData.setFirstName(employeeDetails.getFirstName());
            empData.setLastName(employeeDetails.getLastName());
            empData.setDepartment(employeeDetails.getDepartment());
            empData.setGender(employeeDetails.getGender());
            //empData.setId(id);
            empData.setEmpSalary(employeeDetails.getEmpSalary());
            empData.setMessage(employeeDetails.getMessage());
            return employeeRepo.save(empData);
        } else {
            return new EmployeeDetails("user id not found");
        }
    }
    public String deleteById(int id) {
        Optional<EmployeeDetails> userId = employeeRepo.findById(id);
        if(userId.isPresent()) {
            employeeRepo.deleteById(id);
            return "This id data deleted successfully";
        } else {
            return "This id is not found";
        }

    }
    public Optional<EmployeeDetails> findById(int id) {
        return employeeRepo.findById(id);
    }
}
