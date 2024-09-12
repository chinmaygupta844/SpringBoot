package com.example.demoSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
