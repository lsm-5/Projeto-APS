package com.hotelzin.cinhospede.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotelzin.cinhospede.model.User;
import com.hotelzin.cinhospede.repositories.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() { 
        userRepository.save(new User("Lucas", "lsm5@email.com", "123"));
        System.out.println(userRepository.findAll());
        return "login";
    }
        
    
}