package com.pizzahub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahub.dto.CartItemDto;
import com.pizzahub.service.CartItemService;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping("/addCartItems/{userId}/{prodId}")
	public String addCartItems(@RequestBody CartItemDto cartItemDto,@PathVariable Long userId,@PathVariable Long prodId)
	{
		return cartItemService.addToCart(cartItemDto,userId,prodId);
	}
	
	@DeleteMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable Long cartItemId)
	{
		return cartItemService.deleteFromCart(cartItemId);
	}
	

}
