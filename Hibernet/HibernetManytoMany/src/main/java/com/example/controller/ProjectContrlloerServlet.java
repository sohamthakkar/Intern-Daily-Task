package com.example.controller;

import com.example.services.ProjectServicesImp;
import com.example.services.ProjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProjectServlet", value = "/ProjectServlet")
public class ProjectContrlloerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String flag = req.getParameter("flag");
        if (flag.equals("insert")) {
            insert(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if(flag.equals("search")){
            search(req,resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        ProjectServices emp = new ProjectServicesImp();
        emp.search(req, resp);
    }


    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProjectServices emp = new ProjectServicesImp();
        emp.insert(req, resp);
        resp.sendRedirect("InsertProject.jsp");

    }
}
