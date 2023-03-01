package com.pizzahub.service;

import com.pizzahub.dto.CartItemDto;

public interface CartItemService {

	String addToCart(CartItemDto cartItemDto, Long userId, Long prodId);

	String deleteFromCart(Long cartItemId);

}
