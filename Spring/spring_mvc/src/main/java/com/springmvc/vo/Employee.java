package com.springmvc.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TABLE")
public class Employee {

	/*
	 * @Override public String toString() { return "Employee [id=" + id +
	 * ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
	 * + emailAddress + ", password=" + password + ", city=" + city + ", state="
	 * + state + "]"; }
	 */

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cred=" + cred
				+ ", city=" + city + ", state=" + state + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer id;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;
	/*=
	 * @Column(name = "EMAIL") private String emailAddress;
	 * 
	 * @Column(name = "PASSWORD") private String password;
	 */

	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_CREDENTIALS")
	private EmpCredentials cred;

	@Column(name = "CITY")
	private String city;

	@ManyToOne
	@JoinColumn(name = "CITY_STATE")
	private State state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public String getEmailAddress() { return emailAddress; }
	 * 
	 * public void setEmailAddress(String emailAddress) { this.emailAddress =
	 * emailAddress; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public EmpCredentials getCred() {
		return cred;
	}

	public void setCred(EmpCredentials cred) {
		this.cred = cred;
	}

}
