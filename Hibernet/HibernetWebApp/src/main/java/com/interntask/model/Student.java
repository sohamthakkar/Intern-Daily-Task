package com.interntask.model;

import javax.persistence.*;

@Entity
@Table(name = "student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String studentFn;
    String studentLn;
    String studentEmail;
    String studentMobile;
    String studentAddress;

    public Student(){
    }


    public Student(int id, String studentFn, String studentLn, String studentEmail, String studentMobile, String studentAddress) {
        this.id = id;
        this.studentFn = studentFn;
        this.studentLn = studentLn;
        this.studentEmail = studentEmail;
        this.studentMobile = studentMobile;
        this.studentAddress = studentAddress;
    }

    public Student(String studentFn, String studentLn, String studentEmail, String studentMobile, String studentAddress) {
        this.studentFn = studentFn;
        this.studentLn = studentLn;
        this.studentEmail = studentEmail;
        this.studentMobile = studentMobile;
        this.studentAddress = studentAddress;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentFn() {
        return studentFn;
    }

    public void setStudentFn(String studentFn) {
        this.studentFn = studentFn;
    }

    public String getStudentLn() {
        return studentLn;
    }

    public void setStudentLn(String studentLn) {
        this.studentLn = studentLn;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }




}
