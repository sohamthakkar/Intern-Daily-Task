package com.springmvc.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CREDENTIALS")
public class EmpCredentials {

	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CRED_ID")
	private Integer credId;
	
	@NotEmpty(message="Please! Enter emailAddress........")
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	
	@NotEmpty(message="Please! Enter Password........")
	@Pattern(regexp= "^(?=.*[0-9])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	@Column(name = "PASSWORD")
	private String password;
	
	
	public Integer getCredId() {
		return credId;
	}

	public void setCredId(Integer credId) {
		this.credId = credId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "EmpCredentials [credId=" + credId + ", emailAddress=" + emailAddress + ", password=" + password + "]";
	}

}
