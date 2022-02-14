package com.example.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EmployeeServices {
    void insert(HttpServletRequest req, HttpServletResponse resp);

    List search(HttpServletRequest request, HttpServletResponse response);

    List edit(HttpServletRequest request, HttpServletResponse response);

    void update(HttpServletRequest request, HttpServletResponse response);
}
