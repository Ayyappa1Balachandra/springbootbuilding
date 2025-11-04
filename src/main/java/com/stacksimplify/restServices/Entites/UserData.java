package com.stacksimplify.restServices.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Data")
public class UserData {
	
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String userName;
	private String role;
	private String ssn;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", role=" + role + ", ssn=" + ssn + "]";
	}
	public UserData(Long id, String email, String firstName, String lastName, String userName, String role,
			String ssn) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.role = role;
		this.ssn = ssn;
	}
	
	public UserData() {
		
	}

}
