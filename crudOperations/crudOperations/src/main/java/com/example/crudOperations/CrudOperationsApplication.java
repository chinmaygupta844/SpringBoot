package com.example.crudOperations;

import com.example.crudOperations.dao.StudentDAO;
import com.example.crudOperations.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//	createStudent(studentDAO);
		//	readStudent(studentDAO);
			//findallStudent(studentDAO);
		//	findByLastName(studentDAO);

		//	updateStudent(studentDAO);

			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all student");

		int countrows = studentDAO.deleteAll();
		System.out.println("total rows deleted: "+ countrows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentid = 2;
		studentDAO.delete(studentid);
		System.out.println("student deleted");
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId =1;
		Student s = studentDAO.findbyId(studentId);

		s.setFirstName("chinu");
		studentDAO.update(s);
		System.out.println(s);
	}

	private void findByLastName(StudentDAO studentDAO) {

		List<Student> studentList= studentDAO.findbyLastName("gupta");
		for(Student s: studentList){
			System.out.println(s);
		}
	}

	private void findallStudent(StudentDAO studentDAO) {

		List<Student> studentList= studentDAO.findAll();
		for(Student s: studentList){
			System.out.println(s);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent= new Student("rahul","kumar","rahul@gmail.com");

		studentDAO.save(tempStudent);

		Student s1 = studentDAO.findbyId(tempStudent.getId());
		System.out.println("found the student  "+ s1);

	}

	private void createStudent(StudentDAO studentDAO) {

		Student tempStudent= new Student("chinmay","gupta","chinmay@gmail.com");

		studentDAO.save(tempStudent);

		System.out.println("saved student Genereated Id: "+ tempStudent.getId());
	}


}
