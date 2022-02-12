package com.example.controller;

import com.example.services.ProjectServices;
import com.example.services.ProjectServicesImp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String flag = req.getParameter("flag");
        if (flag.equals("insert")) {
            add(req, resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("projectName");

        ProjectServices projectSer = new ProjectServicesImp();
        projectSer.add(name);

    }
}