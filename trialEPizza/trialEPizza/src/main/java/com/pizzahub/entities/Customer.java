package com.pizzahub.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	private long mobileNo;
	
	private String address;
	
	private int pincode;
	
	@OneToOne(mappedBy = "cartOwner", cascade = CascadeType.ALL ,orphanRemoval = true)//,fetch = FetchType.LAZY fetch = FetchType.LAZY
	private ShoppingCart cart;
	
	@OneToOne(mappedBy = "customer")
	private Wishlist wishlist;
	
	
	

	@Override
	public String toString() {
		return "[CustomerId " + getId() + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo + ", address=" + address + ", pincode=" + pincode + "]";
	}

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String email, String password, long mobileNo, String address,
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

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	
	
	
	

}
