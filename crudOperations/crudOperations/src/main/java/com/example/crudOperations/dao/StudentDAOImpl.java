package com.example.crudOperations.dao;

import com.example.crudOperations.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student thestudent) {
    entityManager.persist(thestudent);
    }

    @Override
    public Student findbyId(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> myquery = entityManager.createQuery("FROM Student order by lastName",Student.class);
        return myquery.getResultList();
    }

    @Override
    public List<Student> findbyLastName(String lastName) {
        TypedQuery<Student> myquery = entityManager.createQuery("FROM Student where lastName =: theData",Student.class);
        myquery.setParameter("theData",lastName);
        return myquery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student s = entityManager.find(Student.class,id);
        entityManager.remove(s);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int countrows = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return countrows;
    }
}
