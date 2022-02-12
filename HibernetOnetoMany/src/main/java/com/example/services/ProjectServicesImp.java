package com.example.services;

import com.example.dao.ProjectDao;
import com.example.model.Project;

public class ProjectServicesImp implements ProjectServices {


    @Override
    public void add(String name) {
        System.out.println("Add project " + name);

        Project project = new Project();
        project.setProjectName(name);

        ProjectDao projectDao = new ProjectDao();
        projectDao.add(project);

    }
}
