package com.springmvc.controller;


import com.springmvc.model.User;
import com.springmvc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired(required = true)
    UserServices userServices;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public ModelAndView testing(Model model){
        System.out.println("page running..");
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("insertUser");
    }

    @RequestMapping(value="insert", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute("user") User user){
        System.out.println(user);

        this.userServices.doInsert(user);

        return new ModelAndView("registersucess");
    }

}