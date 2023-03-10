package com.pizzahub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahub.dto.CartDto;
import com.pizzahub.dto.CartItemDto;
import com.pizzahub.dto.CustomerDto;
import com.pizzahub.service.CustomerService;

@RestController
@RequestMapping("/users")
public class CustomerController {
	
//	@Autowired
//	private WishlistService wishlistService;
	
	
	
	public CustomerController() {
		super();
	}

	@Autowired
	private CustomerService custService;
	
	
	@PostMapping("/login")
	public CustomerDto authenticateCustomer(@RequestParam String email,@RequestParam String password) {
		return custService.validateCustomer(email, password);
	}
	
	@PostMapping
	public String saveCustomerDetails(@RequestBody CustomerDto user)
	{
		return custService.addCustomerDetails(user);
	}
	
	@PostMapping("/addwish/{prodName}/{custEmail}")
	public String addToWishList(@PathVariable String custEmail,@PathVariable String prodName)
	{
		return custService.addProductToWishlist(custEmail, prodName);
	}
	
	@PostMapping("/removewish/{prodName}/{custEmail}")
	public String removeFromWishList(@PathVariable String custEmail,@PathVariable String prodName)
	{
		return custService.removeProductFromWishlist(custEmail, prodName);
	}
	
	@PostMapping("/addtocart/{prodName}/{custEmail}")
	public String addToCart(@RequestBody CartItemDto cartItemDto,@PathVariable String custEmail,@PathVariable String prodName) {
		
		return custService.addToCart(cartItemDto, custEmail, prodName);
	}
	
	@GetMapping("/getcart/{custEmail}")
	public List<CartDto> getCartItems(@PathVariable String custEmail){
		return custService.getAllCartItems(custEmail);
	}

	@PostMapping("/deletefromcart/{cartItemId}")
	public String deleteFromCart(Long cartItemId) {
		return custService.deleteFromCart(cartItemId);
		
	}

	
//	@PutMapping
//	public Customer updateCustomerDetails(@RequestBody Customer user)
//	{
//		return userService.updateCustomerDetails(user);
//	}

}
