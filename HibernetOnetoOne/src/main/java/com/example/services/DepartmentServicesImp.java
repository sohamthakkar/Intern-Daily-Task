package com.example.services;

import com.example.dao.DepartmentDao;
import com.example.model.Department;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DepartmentServicesImp implements DepartmentServices {
    @Override
    public void insertDept(HttpServletRequest request, HttpServletResponse res) throws IOException {

        String name = request.getParameter("nameDept");

        Department dept = new Department();
        dept.setDeptName(name);

        DepartmentDao deptDao = new DepartmentDao();
        try {
            deptDao.insertDept(dept);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        DepartmentDao studentDAO = new DepartmentDao();
        System.out.println("search from Services");
        List<Department> list = studentDAO.searchAll();
        return list;

    }
}
