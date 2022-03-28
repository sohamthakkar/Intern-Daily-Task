package com.example.controller;

import com.example.model.User;
import com.example.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControllerServlet {

    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "insertData.html", method = RequestMethod.GET)
    public ModelAndView mv(){
        return new ModelAndView("insertUser","key",new User());
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public  ModelAndView insertUsers(@ModelAttribute("key") User user){
        this.userServices.insert(user);
        return new ModelAndView("insertSuceess");
    }

}