package com.example.services;

import com.example.dao.EmployeeDao;
import com.example.dao.ProjectDao;
import com.example.model.Employee;
import com.example.model.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class EmployeeServicesImp implements EmployeeServices {
    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("insertEmp");

        Employee emp = new Employee();
        emp.setEmployeeName(name);

        EmployeeDao dao = new EmployeeDao();
        dao.insert(emp);

    }

    @Override
    public List search(HttpServletRequest request, HttpServletResponse response) {
        EmployeeDao dao = new EmployeeDao();
        List searchEmp = dao.search();
        System.out.println("Results out");
        return searchEmp;
    }

    @Override
    public List edit(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        EmployeeDao dao = new EmployeeDao();
        List editEmp = dao.edit(id);
        return editEmp;
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        String empid = request.getParameter("empId");
        String[] projectsId = request.getParameterValues("proId");
        System.out.println(Arrays.toString(projectsId));

        Employee emp = new Employee();
        emp.setEmployeeId(Integer.parseInt(empid));
        Set<Employee> employeeSet = new HashSet<Employee>();
        employeeSet.add(emp);


        Set<Project> projectSet = new HashSet<Project>();
        for(String projectId: projectsId){
            Project project = new Project();
            project.setProjectId(Integer.parseInt(projectId));

            projectSet.add(project);

            project.setEmployees(employeeSet);

            ProjectDao dao = new ProjectDao();
            dao.update(project);
        }


//
//        Employee emp = new Employee();
//        emp.setEmployeeId(Integer.parseInt(empid));
//        List<Project> projectList = new ArrayList<>();
//        emp.setProjects(projectList);
//
//        for (String pro:Arrays.asList(projectsId)) {
//            Project projects = new Project();
//            projects.setProjectId(Integer.parseInt(pro));
//            projectList.add(projects);
//        }



    }
}
