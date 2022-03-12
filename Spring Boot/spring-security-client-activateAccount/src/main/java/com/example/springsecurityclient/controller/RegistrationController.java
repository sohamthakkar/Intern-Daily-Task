package com.example.springsecurityclient.controller;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.event.RegistrationCompleteEvent;
import com.example.springsecurityclient.model.UserModel;
import com.example.springsecurityclient.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping("/hello")
    public String loginUser() {
        return "Welcome to Api Page but you need postman or other sw for run api";

    }

    @PostMapping("/register")
    public String saveEmployee(@RequestBody UserModel userModel, final HttpServletRequest request){
        System.out.println(userModel.toString());
        User user = userServices.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,aplicationUrl(request)
        ));
        return "success";
    }

    private String aplicationUrl(HttpServletRequest request) {
        return "http://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + "/"
                + request.getContextPath();
    }

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello From Oauth2.0";
    }


}
