package com.pizzahub.entities;

import javax.persistence.Entity;

@Entity
public class Staff extends BaseEntity {
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private long mobileNo;
	
	private String address;
	
	private int pincode;
	
	

	@Override
	public String toString() {
		return "[ StaffId " + getId() + " firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo + ", address=" + address + ", pincode=" + pincode + "]";
	}

	public Staff() {
		super();
	}

	public Staff(String firstName, String lastName, String email, String password, long mobileNo, String address,
			int pincode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.address = address;
		this.pincode = pincode;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	
	
	
	

	
	

}
