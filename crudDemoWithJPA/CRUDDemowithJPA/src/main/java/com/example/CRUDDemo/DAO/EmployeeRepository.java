package com.example.CRUDDemo.DAO;

import com.example.CRUDDemo.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<employee,Integer> {

}
