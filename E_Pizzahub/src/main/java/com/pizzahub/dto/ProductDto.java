package com.pizzahub.dto;

public class ProductDto {
//	private Long Id;
	private String productName;
	private double price;
	private String prodImage;
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	private String description;
	private boolean inStock;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
//	public Long getId() {
//		return Id;
//	}
//	public void setId(Long id) {
//		Id = id;
//	}
//	
	

}
