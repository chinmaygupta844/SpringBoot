package com.luv2code.springboot.thymleafDemo.controller;

import com.luv2code.springboot.thymleafDemo.entity.Employee;
import com.luv2code.springboot.thymleafDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

   @GetMapping ("/list")
    public String listEmployees(Model model){
        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employees",employeeList);

        return "/employees/list-employees";
   }
   @GetMapping ("AddEmployeeForm")
    public String addEmployee(Model model){
        Employee e = new Employee();
        model.addAttribute("employee",e);
        return "/employees/employee-form";
   }
   @PostMapping("/save")
    public String saveEmployees(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
   }
   @GetMapping("/updateEmployeeForm")
    public String updateEmployee(@RequestParam("employeeId") int id,Model model){

        Employee e = employeeService.findById(id);

        model.addAttribute("employee",e);
        return "employees/employee-form";
   }
   @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
   }
}
