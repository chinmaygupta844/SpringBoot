package com.example.CRUDDemo.Service;

import com.example.CRUDDemo.entity.employee;

import java.util.List;

public interface EmployeeService {
    List<employee> findAll();
    employee findbyId(int id);
    employee save (employee e);
    void deleteById(int id);
}
