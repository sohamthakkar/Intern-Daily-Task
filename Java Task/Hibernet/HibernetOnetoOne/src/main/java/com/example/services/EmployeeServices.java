package com.example.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface EmployeeServices {
    void insert(HttpServletRequest request, HttpServletResponse response);

    List searchEmp(HttpServletRequest request, HttpServletResponse response) throws IOException;

    List edit(HttpServletRequest request, HttpServletResponse response);

    void update(HttpServletRequest request, HttpServletResponse response);
}
