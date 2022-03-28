package com.example.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID")
    private int employeeId;
    @Column(name = "Employee_Name")
    private  String employeeName;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects;

    public  Employee(){
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
