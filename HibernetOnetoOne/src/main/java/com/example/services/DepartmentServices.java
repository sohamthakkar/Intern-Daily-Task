package com.example.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public interface DepartmentServices {
    void insertDept(HttpServletRequest req, HttpServletResponse res) throws IOException;
    List search(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
