package com.example.model;

import javax.persistence.*;
import java.security.PrivateKey;


@Entity
@Table(name = "EmployeesData")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;

    @OneToOne
    @JoinColumn(name = "deptId")
    private Department deptId;

    public Employee() {
    }

    public Employee(int empId, String empName, Department deptId) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }
}
