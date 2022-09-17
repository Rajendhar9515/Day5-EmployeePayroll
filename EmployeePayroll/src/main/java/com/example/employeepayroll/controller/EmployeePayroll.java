package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.model.EmployeeDetails;
import com.example.employeepayroll.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayroll {

    @Autowired
    EmployeePayrollService employeePayrollService;

    List<EmployeeDetails> list = new ArrayList<>();

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Data saved successfully", employeePayrollService.saveAll(employeeDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/empdata")
    public List<EmployeeDetails> displayAll(){
        return employeePayrollService.display();
    }
    @GetMapping("/find/{id}")
    public Optional<EmployeeDetails> findById(@PathVariable int id ){
        return employeePayrollService.findById(id);
    }

    @PutMapping("/edit/{id}")
    public EmployeeDetails update(@RequestBody EmployeeDetails employeeDetails, @PathVariable int id) {
       return employeePayrollService.update(employeeDetails, id);
    }

    @DeleteMapping("/remove/{id}")
    public String delete(@PathVariable int id){
        return employeePayrollService.deleteById(id);
    }
}

