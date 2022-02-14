package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/userList")
public class UserServlet extends HttpServlet {

    public UserServlet(){
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            String flag = request.getParameter("flag");
            if (flag.equals("search")) {

                search(request, response);

            } else if (flag.equals("edit")) {

                edit(request, response);

            } else if (flag.equals("update")) {
                update(request, response);
            }

            else if (flag.equals("delete")) {

                delete(request, response);

            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("text/html");

        String flag = req.getParameter("flag");

        if (flag.equals("insert")){
            try{
                insert(req,resp);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String condition = request.getParameter("condition");
        String emailPattern = "\"^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$\"";

        if (condition == null){
            out.println("Please select condition");
        }else if (fname.length() < 3){
            out.println("Enter your name");
        }else if (lname.length() <= 3){
            out.println("Enter your last name");
        }else if (mobile.length() != 10){
            out.println("ENter correct number");
        }else if (!email.matches(emailPattern)){
            out.println("ENter correct email");
        }else {
            User user = new User();
            user.setFname(fname);
            user.setLname(lname);
            user.setMobile(mobile);
            user.setEmail(email);

            UserDAO userdao = new UserDAO();
            boolean ans = userdao.insert(user);
            out.println(fname);
            out.println(lname);
            out.println(mobile);
            out.println(email);

            if (ans){
                System.out.println("Added Successfully");
            }else {
                System.out.println("Something wrong...");
            }
            System.out.println(user);

        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {

        int deleteId = Integer.parseInt(request.getParameter("id"));

        User user = new User();
        user.setId(deleteId);

        UserDAO userDao = new UserDAO();
        userDao.delete(user);

        response.sendRedirect("user-list.jsp");

    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        UserDAO userDao = new UserDAO();
        List list = userDao.searchAll();

        HttpSession hs = request.getSession();
        hs.setAttribute("UserList", list);
        out.println(list);
        response.sendRedirect("user-list.jsp");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));

        User user = new User();
        user.setId(userId);

        UserDAO userDao = new UserDAO();
        List editList = userDao.edit(user);

        HttpSession hs = request.getSession();
        hs.setAttribute("EditUser", editList);

        response.sendRedirect("editUserData.jsp");

    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();

        user.setId(id);
        user.setFname(firstName);
        user.setLname(lastName);
        user.setMobile(userName);
        user.setEmail(password);

        UserDAO userDao = new UserDAO();
        userDao.update(user);

        out.println(firstName);
        out.println(lastName);
        out.println(userName);
        out.println(password);

    }

}

