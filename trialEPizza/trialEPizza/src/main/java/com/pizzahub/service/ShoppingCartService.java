package com.pizzahub.service;

import com.pizzahub.dto.ShoppingCartDto;

public interface ShoppingCartService {



	String createCart(ShoppingCartDto shoppingDto, Long id);

}
