package com.example.controller;

import com.example.model.Department;
import com.example.services.DepartmentServices;
import com.example.services.DepartmentServicesImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "DepartmentController", value = "/DepartmentController")
public class DepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String flag = req.getParameter("flag");
        if (flag.equals("search")){

            search(req,resp);

        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DepartmentServices empser = new DepartmentServicesImp();
        System.out.println("search from servlet");
        List<Department> ls = empser.search(req,resp);
        PrintWriter out = resp.getWriter();
        HttpSession hs = req.getSession();
        hs.setAttribute("List", ls);
        resp.sendRedirect("AddEmployee.jsp");
        out.println(ls);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        DepartmentServices employeeServices =new DepartmentServicesImp();
        String flag = req.getParameter("flag");
        if (flag.equals("insert")){
            employeeServices.insertDept(req,resp);
            resp.sendRedirect("index.jsp");
        }
    }


}
