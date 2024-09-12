package com.example.CRUDDemo.rest;



import com.example.CRUDDemo.Service.EmployeeService;
import com.example.CRUDDemo.entity.employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class employeeRestController {

    private EmployeeService employeeService;

    public employeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public employee getEmployee(@PathVariable int employeeId){
        employee emp= employeeService.findbyId(employeeId);
        if(emp ==null){
            throw new RuntimeException("employee id not found - " + employeeId);
        }
        return emp;
    }

    @PostMapping("/employees")
    public employee saveEmployee(@RequestBody employee emp){
        emp.setId(0);
        employee e = employeeService.save(emp);
        return  e;
    }
    @PutMapping("/employees")
    public employee UpdateEmployee(@RequestBody employee emp){
        employee e = employeeService.save(emp);
        return  e;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        employee emp= employeeService.findbyId(employeeId);
        if(emp ==null){
            throw new RuntimeException("employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "deleted employee id -" + employeeId;
    }
}
