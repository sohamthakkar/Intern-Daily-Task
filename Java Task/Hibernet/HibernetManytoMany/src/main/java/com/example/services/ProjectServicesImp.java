package com.example.services;

import com.example.dao.EmployeeDao;
import com.example.dao.ProjectDao;
import com.example.model.Project;
import com.example.services.ProjectServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProjectServicesImp implements ProjectServices {
    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("projectName");

        Project project = new Project();
        project.setProjectName(name);

        ProjectDao projectDao = new ProjectDao();
        projectDao.insert(project);

    }

    @Override
    public List search(HttpServletRequest req, HttpServletResponse resp) {
        ProjectDao dao = new ProjectDao();
        List projects = dao.search();
        return projects;
    }
}
