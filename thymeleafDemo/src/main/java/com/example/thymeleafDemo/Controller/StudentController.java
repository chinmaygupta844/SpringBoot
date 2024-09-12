package com.example.thymeleafDemo.Controller;

import com.example.thymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystem}")
    private List<String> operatingSystem;



    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);
        //adding countries;
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("operatingSystem",operatingSystem);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println(student.getFirstName()+student.getCountry()+student.getLanguage());
        return "student-confirmation";
    }
}
