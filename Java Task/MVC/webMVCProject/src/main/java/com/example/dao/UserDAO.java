package com.example.dao;

import com.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserDAO {
//this database operation provide the crud database opertion for the table user in  the databses.

    public boolean insert(User user)  {
        boolean f = false;
        try {

            Connection con = CP.createC();

            String Query = "Insert into information (fname,lname, mobile, email) values (?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(Query);
            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getLname());
            preparedStatement.setString(3, String.valueOf(user.getMobile()));
            preparedStatement.setString(4, user.getEmail());

            preparedStatement.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }

    public ArrayList searchAll() throws ClassNotFoundException, SQLException {

        ArrayList list = new ArrayList();
        Connection con = CP.createC();
        java.sql.Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM information");

        while (rs.next()) {

            int id = rs.getInt("uid");
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");

            User user = new User();
            user.setId(id);
            user.setFname(fname);
            user.setLname(lname);
            user.setMobile(mobile);
            user.setEmail(email);

            list.add(user);
        }

        return list;
    }

    public List edit(User user) throws ClassNotFoundException, SQLException {
        ArrayList editList = new ArrayList();
        Connection con = CP.createC();
        java.sql.Statement statement = con.createStatement();

        int userid = user.getId();

        ResultSet rs = statement.executeQuery("SELECT * FROM information WHERE uid = '" + userid + "'");

        while (rs.next()) {

            int id = rs.getInt("uid");
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");

            User editUser = new User();
            editUser.setId(id);
            editUser.setFname(fname);
            editUser.setLname(lname);
            editUser.setMobile(mobile);
            editUser.setEmail(email);

            editList.add(editUser);
        }

        return editList;
    }

    public void update(User user) throws ClassNotFoundException, SQLException {

        Connection con = CP.createC();
        java.sql.Statement statement = con.createStatement();

        int id = user.getId();
        String firstName = user.getFname();
        String lastName = user.getLname();
        String mobile = user.getMobile();
        String email = user.getEmail();

        System.out.println(firstName + " : " + lastName + " : " + mobile + " : " + email);

        statement.executeUpdate("UPDATE information SET fname = '" + firstName + "', lname = '" + lastName
                + "', mobile = '" + mobile + "',email = '" + email + "' WHERE uid = '" + id + "'");

    }

    public void delete(User user) throws ClassNotFoundException, SQLException {
        Connection con = CP.createC();
        java.sql.Statement statement = con.createStatement();

        int userId = user.getId();

        statement.executeUpdate("DELETE FROM information WHERE uid = '" + userId + "'");

    }
}