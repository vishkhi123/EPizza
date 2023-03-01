package com.pizzahub.dto;

import java.time.LocalDate;

public class ShoppingCartDto {
	
    private int totalItems;
	private double totalCartPrice;
	private LocalDate createdOn;
	private LocalDate lastUpdatedOn;
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
	
	

}
