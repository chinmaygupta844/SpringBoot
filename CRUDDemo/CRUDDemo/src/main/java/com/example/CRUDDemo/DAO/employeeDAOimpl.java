package com.example.CRUDDemo.DAO;

import com.example.CRUDDemo.entity.employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class employeeDAOimpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public employeeDAOimpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<employee> findAll() {

        TypedQuery query = entityManager.createQuery("FROM employee", employee.class);
        List<employee> employees= query.getResultList();

        return employees;
    }

    @Override
    public employee findbyId(int id) {
        employee emp = entityManager.find(employee.class,id);

        return emp;
    }

    @Override
    public employee save(employee e) {
        // merge will do if id =0 the insert/save else update
        employee emp = entityManager.merge(e);
        return emp;
    }

    @Override
    public void deleteById(int id) {
        employee e = entityManager.find(employee.class,id);
        entityManager.remove(e);
    }
}
