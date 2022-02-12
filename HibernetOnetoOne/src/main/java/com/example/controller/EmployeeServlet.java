package com.example.controller;


import com.example.dao.DepartmentDao;
import com.example.model.Employee;
import com.example.services.EmployeeServices;
import com.example.services.EmployeeServicesImp;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "employeeController", value = "/employeeController")
public class EmployeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String flag = request.getParameter("flag");

        if (flag.equals("search")){
            searchEmp(request, response);
        }else if (flag.equals("edit")){
            edit(request, response);
        }else if (flag.equals("delete")){
            delete(request, response);
        }else if(flag.equals("update")){
            update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmployeeServices empser = new EmployeeServicesImp();
        empser.update(request, response);
        response.sendRedirect("employeeController?flag=search");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        EmployeeServices employeeServices = new EmployeeServicesImp();
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {

        EmployeeServices employeeServices = new EmployeeServicesImp();
        List ls = employeeServices.edit(request, response);

        HttpSession hs = request.getSession();

        DepartmentDao dao = new DepartmentDao();
        List lsAll = dao.searchAll();
        hs.setAttribute("AllList", lsAll);

        PrintWriter out = response.getWriter();

        hs.setAttribute("List", ls);
        response.sendRedirect("editEmployeeList.jsp");
        out.println(ls);
        out.println("Successfully send data to jsp file");
    }

    private void searchEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmployeeServices employeeServices = new EmployeeServicesImp();
        List<Employee> list = employeeServices.searchEmp(request, response);
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession();
        hs.setAttribute("List", list);
        response.sendRedirect("EmployeeList.jsp");
        out.println(list);
        out.println("Successfully send data to jsp file");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");

        if (flag.equals("insert")){
            insert(req, resp);
        }

    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EmployeeServices employeeServices = new EmployeeServicesImp();
        employeeServices.insert(req, resp);
        resp.sendRedirect("employeeController?flag=search");

    }
}