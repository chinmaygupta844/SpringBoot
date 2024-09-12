package com.work.study.SpringExample.controllers;


// operationns
//GET /employees
//POST /employees
//DELETE /employees/{id}

import com.work.study.SpringExample.dto.EmployeeDTO;
import com.work.study.SpringExample.services.EmployeeService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){

        return employeeService.getAllEmployees();
    }


   @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
return employeeService.createNewEmployee(employeeDTO);
   }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping(path = "/count")
    public long getCountOfEmployees(){
        return employeeService.getCountOfEmployees();
    }
}
