package com.example.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Project_Table")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Project_ID")
    private int projectId;

    @Column(name = "Project_Name")
    private String projectName;

    @ManyToMany
    @JoinTable(name = "Employee_Project",
            joinColumns = {@JoinColumn(name = "pid")},
            inverseJoinColumns = {@JoinColumn(name = "eid")}
    )
    private Set<Employee> employees;



    public  Project(){}

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
