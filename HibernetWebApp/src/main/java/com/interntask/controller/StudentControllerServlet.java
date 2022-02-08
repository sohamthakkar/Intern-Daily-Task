package com.interntask.controller;

import com.interntask.dao.StudentDAO;
import com.interntask.model.Student;
import com.interntask.services.StudentServices;
import com.interntask.services.StudentServicesClass;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        StudentServices studentSer = new StudentServicesClass();
        String flag = request.getParameter("flag");
        try {
            if (flag.equals("search")) {
                studentSer.search(request, response);
            } else if (flag.equals("edit")) {
                System.out.println("Edting start......");
                studentSer.edit(request, response);
            } else if (flag.equals("update")) {
                studentSer.update(request, response);
            }
            else if (flag.equals("delete")) {
                studentSer.delete(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String flag = req.getParameter("flag");

        StudentServices studentSer = new StudentServicesClass();

        if (flag.equals("insert")){
            try {
                studentSer.insert(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}