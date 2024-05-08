package com.login.loginwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.loginwebservice.models.User;
import com.login.loginwebservice.models.UserRepository;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/login")
    public String login() {
      return "login";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/reset")
    public String reset() {
        return "reset";
    }

    @PutMapping("/reset")
    public String resetPassword(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login?success";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login?success";
    }
}
