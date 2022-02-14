package com.example.controller;

import com.example.dao.ProjectDao;
import com.example.model.Employee;
import com.example.services.EmployeeServices;
import com.example.services.EmployeeServicesImp;
import com.example.services.ProjectServices;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "employeeServlet", value = "/employeeServlet")
public class EmployeeControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String flag = request.getParameter("flag");
        if(flag.equals("search")){
            search(request,response);
        }
        else if (flag.equals("edit")){
            edit(request, response);
        }else if (flag.equals("delete")){
            delete(request, response);
        }
    }


    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmployeeServices empService = new EmployeeServicesImp();
        List<Employee> empLs = empService.edit(request,response);
        HttpSession hs = request.getSession();
        hs.setAttribute("empList",empLs);

        HttpSession hs1 = request.getSession();
        ProjectDao projectDao = new ProjectDao();
        List projets = projectDao.search();
        hs1.setAttribute("projets",projets);
        response.sendRedirect("EditEmployee.jsp");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmployeeServices empService = new EmployeeServicesImp();
        HttpSession hs = request.getSession();
        List list1 = empService.search(request,response);
        hs.setAttribute("empList",list1);
        response.sendRedirect("EmployeeList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag = request.getParameter("flag");
        if(flag.equals("insertEmp")){
            insert(request,response);
        }else if(flag.equals("update")){
            update(request,response);
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       EmployeeServices empService = new EmployeeServicesImp();
       empService.insert(req,resp);
       resp.sendRedirect("InsertEmployee.jsp");
    }
    private void update(HttpServletRequest request, HttpServletResponse response) {
        EmployeeServices empser = new EmployeeServicesImp();
        empser.update(request,response);
    }
}