package com.example.crudOperations.dao;

import com.example.crudOperations.entity.Student;

import java.util.List;


public interface StudentDAO   {

    void save (Student thestudent);
    Student findbyId(Integer id);
    List<Student> findAll();
    List<Student> findbyLastName(String lastName);

    void update(Student student);
    void delete (Integer id);
    int deleteAll();
}
