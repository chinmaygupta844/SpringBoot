package com.example.thymeleafDemo.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }

    // controller for read and write data from model
        @RequestMapping("/processFormV2")
        public String capsData(HttpServletRequest request, Model model){
        String data = request.getParameter("studentName");
        data = data.toUpperCase();

        String result = "hello" + data;
        model.addAttribute("message",result);
        return "helloWorld";
        }

        // another method we use in spring normally
        @RequestMapping("/processFormV3")
        public String capsData2(@RequestParam("studentName") String name, Model model){

            name = name.toUpperCase();

            String result = "using Param " + name;
            model.addAttribute("message",result);
            return "helloWorld";
        }
}
