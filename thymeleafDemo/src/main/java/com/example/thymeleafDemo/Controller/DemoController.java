package com.example.thymeleafDemo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {

    @GetMapping("/hello")

    public String sayHello(Model model){
        model.addAttribute("thedate",java.time.LocalDateTime.now());
        return "helloWorld";
    }
}
