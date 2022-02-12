package com.interntask.services;

import com.interntask.dao.StudentDAO;
import com.interntask.model.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class StudentServicesClass implements StudentServices{

    @Override
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String condition = request.getParameter("condition");
        String emailPattern = "\"^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$\"";

        //set in Student model class or pojo class
        // pojo or model class also known as VO
        Student student = new Student();
        student.setStudentFn(fname);
        student.setStudentLn(lname);
        student.setStudentEmail(email);
        student.setStudentMobile(mobile);
        student.setStudentAddress(address);

        //send to dao class or controller
        StudentDAO stuDAO = new StudentDAO();
        stuDAO.insert(student);
    }

    @Override
    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        PrintWriter out = response.getWriter();

        StudentDAO studentDAO = new StudentDAO();
        List<Student> list = studentDAO.searchAll();

        HttpSession hs = request.getSession();
        hs.setAttribute("UserList", list);
        out.println(list);
        response.sendRedirect("StudentsList.jsp");
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int deleteId = Integer.parseInt(request.getParameter("id"));

        Student user = new Student();
        user.setId(deleteId);

        StudentDAO userDao = new StudentDAO();
        userDao.delete(user);

        response.sendRedirect("StudentsList.jsp");
    }



    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int stuid =Integer.parseInt(request.getParameter("id"));

        Student student = new Student();
        student.setId(stuid);

        StudentDAO studentDAO = new StudentDAO();
        List<Student> list = studentDAO.edit(student);

        HttpSession hs = request.getSession();
        hs.setAttribute("EditList", list);
        response.sendRedirect("editStudentList.jsp");
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        Student user = new Student();

        user.setId(id);
        user.setStudentFn(firstName);
        user.setStudentLn(lastName);
        user.setStudentMobile(userName);
        user.setStudentEmail(password);
        user.setStudentAddress(address);

        StudentDAO userDao = new StudentDAO();
        userDao.update(user);

        out.println(firstName);
        out.println(lastName);
        out.println(userName);
        out.println(password);
    }
}
