package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Employee_name")
    private String name;

    @OneToMany
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public Employee(int id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
