package com.example.model;

public class User {
    private int id;
    private String fname;
    private String lname;
    private String mobile;
    private String email;

    public User(int id, String fname, String lname, String mobile, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
    }

    public User(String fname, String lname, String mobile, String email) {
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
