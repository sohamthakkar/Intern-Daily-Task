package com.example.services;


import com.example.dao.EmployeeDao;
import com.example.model.Department;
import com.example.model.Employee;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeServicesImp implements EmployeeServices{

    @Override
    public void insert(HttpServletRequest request, HttpServletResponse response) {

        String empName = request.getParameter("empName");
        int deptid = Integer.parseInt(request.getParameter("deptId"));

        //set in department model class object
        Department department = new Department();
        department.setDeptId(deptid);

        //set department objet in employee model class object
        Employee employee = new Employee();
        employee.setEmpName(empName);
        employee.setDeptId(department);

        //call insert method in employeeDaoImp class
        EmployeeDao emppDao = new EmployeeDao();
        emppDao.insert(employee);


    }

    @Override
    public List searchEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        EmployeeDao emppDao = new EmployeeDao();
        System.out.println("Searching from EmplServices");
        List<Employee> empList = emppDao.searchEmp();
        return empList;
    }

    @Override
    public List edit(HttpServletRequest request, HttpServletResponse response) {
        int empId = Integer.parseInt(request.getParameter("id"));
        Employee employee = new Employee();
        employee.setEmpId(empId);
        EmployeeDao emppDao = new EmployeeDao();
        List<Employee> list = emppDao.edit(employee);
        return list;
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        int empId = Integer.parseInt(request.getParameter("id"));
        String empName = request.getParameter("empName");
        int deptId = Integer.parseInt(request.getParameter("deptId"));

        //set in department model class object
        Department department = new Department();
        department.setDeptId(deptId);

        //set department objet in employee model class object
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setDeptId(department);

        //call update method in employeeDaoImp class
        EmployeeDao emppDao = new EmployeeDao();
        emppDao.update(employee);
    }


}
