package com.login.loginwebservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
      return "login";
    }

    @RequestMapping("/reset")
    public String reset() {
        return "reset";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
