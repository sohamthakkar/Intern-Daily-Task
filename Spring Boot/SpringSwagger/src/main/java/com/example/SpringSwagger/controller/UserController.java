package com.example.SpringSwagger.controller;

import com.example.SpringSwagger.model.User;
import com.example.SpringSwagger.services.UserServices;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        System.out.println(user);
        userServices.saveUser(user);
    }
    @GetMapping("/user")
    public List<User> displayUser(){
        return userServices.displayUser();
    }
}
