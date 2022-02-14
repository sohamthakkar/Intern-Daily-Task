package com.example.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ProjectServices {
    void insert(HttpServletRequest req, HttpServletResponse resp);

    List search(HttpServletRequest req, HttpServletResponse resp);
}
