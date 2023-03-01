package com.pizzahub.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Wishlist extends BaseEntity {
	
	@OneToMany
	private List<Product> products=new ArrayList<Product>();
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	
	
	public void addProduct(Product product)
	{
		this.products.add(product);
	}

	public void removeProduct(Product product)
	{
		this.products.remove(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
