package com.buvanesh.taskmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
    @GetMapping("/users")
    public String getUsers(){
        return "Buvanesh";
    }
}
