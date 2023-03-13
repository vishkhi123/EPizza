package com.pizzahub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahub.dto.ShoppingCartDto;
import com.pizzahub.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingService;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	@PostMapping("/add/{custId}")
	public String addShoppingCart(@RequestBody ShoppingCartDto shoppingDto,@PathVariable Long custId )
	{
		return shoppingService.createCart(shoppingDto,custId);
	}

}
