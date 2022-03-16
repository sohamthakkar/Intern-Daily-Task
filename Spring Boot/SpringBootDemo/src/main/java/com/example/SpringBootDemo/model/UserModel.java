package com.example.SpringBootDemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "User_Data")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private int id;
	
	@NotEmpty(message = "Firstname can not be null...")
	@Column(name = "first_Name", nullable = false)
	private String fname;
	
	
	@NotEmpty(message = "Lastname can not be null...")
	@Column(name = "Last_Name")
	private String lname;
	
	
	@NotEmpty(message = "Lastname can not be null...")
	@Column(name = "Email_ID")
	private String email;
	
	@NotEmpty(message = "Lastname can not be null...")
	@Column(name="Mobile_Number")
	private String mobile;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
