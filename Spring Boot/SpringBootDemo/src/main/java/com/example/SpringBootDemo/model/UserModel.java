package com.example.SpringBootDemo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	@Column(name = "Email_ID", unique = true)
	private String email;
	
	@NotEmpty(message = "Lastname can not be null...")
	@Column(name="Mobile_Number")
	private String mobile;

	public UserModel(String fname, String lname, String email, String mobile) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
	}
}
