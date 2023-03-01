package com.pizzahub.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class ShoppingCart extends BaseEntity {
	
	private int totalItems;
	
	private double totalCartPrice;
	
    @CreationTimestamp // hib annotation to add creation date auto : once @ time of saving the entity
	private LocalDate createdOn;
    
    @UpdateTimestamp // hib annotation to update the date auto : @ time of updating cart
	private LocalDate lastUpdatedOn;
    
    @OneToOne // def fetch type : EAGER
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer cartOwner;
    
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems = new ArrayList<>();

  //add helper methods : linking n de linking
  	public void addCartItem(CartItem item)
  	{
  		cartItems.add(item);
  		item.setCart(this);
  	}
  	public void removeCartItem(CartItem item)
  	{
  		cartItems.remove(item);
  		item.setCart(null);
  	}

  	
	@Override
	public String toString() {
		return "ShoppingCart [totalItems=" + totalItems + ", totalCartPrice=" + totalCartPrice + ", createdOn="
				+ createdOn + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public double getTotalCartPrice() {
		return totalCartPrice;
	}

	public void setTotalCartPrice(double totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Customer getCartOwner() {
		return cartOwner;
	}

	public void setCartOwner(Customer cartOwner) {
		this.cartOwner = cartOwner;
	}
	

	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public ShoppingCart(int totalItems, double totalCartPrice, LocalDate createdOn, LocalDate lastUpdatedOn) {
		super();
		this.totalItems = totalItems;
		this.totalCartPrice = totalCartPrice;
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public ShoppingCart() {
		super();
	}
    
    
    

}
