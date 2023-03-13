package com.pizzahub.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends BaseEntity {
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Admin(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}



	@Override
	public String toString() {
		return "[AdminId " + getId() + " firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
