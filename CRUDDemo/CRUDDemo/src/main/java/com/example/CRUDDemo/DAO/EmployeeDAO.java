package com.example.CRUDDemo.DAO;

import com.example.CRUDDemo.entity.employee;

import java.util.List;

public interface EmployeeDAO {
    List<employee> findAll();
    employee findbyId(int id);
    employee save (employee e);
    void deleteById(int id);
}
