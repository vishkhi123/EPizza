package com.pizzahub.service;

import java.util.List;

import com.pizzahub.dto.CartDto;
import com.pizzahub.dto.CartItemDto;
import com.pizzahub.dto.CustomerDto;
import com.pizzahub.entities.Customer;

public interface CustomerService {
	
	String addCustomerDetails(CustomerDto user);
	
	Customer updateCustomerDetails(Customer user);

	String addProductToWishlist(String email, String prodName);

	String removeProductFromWishlist(String custEmail, String prodName);

	String addToCart(CartItemDto cartItemDto, String custEmail, String prodName);

	String deleteFromCart(Long cartItemId);

	CustomerDto validateCustomer(String email, String password);

	List<CartDto> getAllCartItems(String custEmail);

}
