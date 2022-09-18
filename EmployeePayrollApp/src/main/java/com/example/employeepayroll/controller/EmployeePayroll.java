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
    public ResponseEntity<ResponseDTO> displayAll(){
        ResponseDTO responseDTO = new ResponseDTO("Get call successfully", employeePayrollService.display());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable int id ){
        Optional<EmployeeDetails> empData = employeePayrollService.findById(id);
        String message = empData.isPresent() ? "Get call for Id successfully" : "employee id not found";
        ResponseDTO responseDTO = new ResponseDTO(message, employeePayrollService.findById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Updated data successfully", employeePayrollService.update(employeeDTO, id));
       return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        Boolean isEmpID = employeePayrollService.deleteById(id);
        String message = isEmpID ? "Deleted by Id successfully" : "Id is Not Found";
        ResponseDTO responseDTO = new ResponseDTO(message);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

