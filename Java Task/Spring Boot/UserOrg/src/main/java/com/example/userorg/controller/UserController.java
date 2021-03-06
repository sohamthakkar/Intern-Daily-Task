package com.example.userorg.controller;

import com.example.userorg.model.User;
import com.example.userorg.servics.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/addUser")
    public User getUser(@Valid @RequestBody User user) {
        return userServices.addUser(user);
    }

    @GetMapping("/showUsers")
    public List<User> getUsers(){
        return userServices.showUsers();
    }

    @GetMapping("?userID={id}")
    public User getUser(@PathVariable("id") long id){
        return userServices.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @Valid @RequestBody User user){
        return userServices.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable long id){
        userServices.deleteUser(id);
        return "user Deleted Successfully";
    }
}
