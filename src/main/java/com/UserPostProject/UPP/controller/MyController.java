package com.UserPostProject.UPP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String loginPage(){
        return "/Login/LoginPage";
    }

    @GetMapping("/register")
    public String registrationPage(){
        return "/Login/RegistrationPage";
    }

}
