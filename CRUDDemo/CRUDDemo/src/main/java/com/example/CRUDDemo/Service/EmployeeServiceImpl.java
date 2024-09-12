package com.example.CRUDDemo.Service;

import com.example.CRUDDemo.DAO.EmployeeDAO;
import com.example.CRUDDemo.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    @Override
    public List<employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public employee findbyId(int id) {
        return employeeDAO.findbyId(id);
    }
    @Transactional
    @Override
    public employee save(employee e) {
        return employeeDAO.save(e);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
