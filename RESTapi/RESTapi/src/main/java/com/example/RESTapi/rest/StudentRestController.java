package com.example.RESTapi.rest;

import com.example.RESTapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("chinmay","gupta"));
        students.add(new Student("piyush","thakur"));
        students.add(new Student("tatvid","tripathi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId>= students.size() || studentId<0){
            throw new StudentNotFoundException("student id not found - " +studentId);
        }
        return students.get(studentId);
    }


}
