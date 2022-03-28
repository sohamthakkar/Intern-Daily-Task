package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Projects")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "empId")
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project(String projectName, Employee employee) {
        this.projectName = projectName;
        this.employee = employee;
    }

    public Project(int pid, String projectName, Employee employee) {
        this.pid = pid;
        this.projectName = projectName;
        this.employee = employee;
    }

    public Project(){
    }



    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
