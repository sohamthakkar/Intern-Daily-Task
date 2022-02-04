package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CP {
    static Connection conn;
    public static  Connection createC() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/usersdata";
        String jdbcusername = "root";
        String jdbcPass = "jaygohel";
        conn = DriverManager.getConnection(jdbcUrl,jdbcusername,jdbcPass);

        return conn;
    }
}
