package com.interntask.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface StudentServices {
    void insert(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void delete(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void search(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException;
    void edit(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void update(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
