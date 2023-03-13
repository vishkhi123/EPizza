package com.pizzahub.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.dto.CartItemDto;
import com.pizzahub.entities.CartItem;
import com.pizzahub.entities.Product;
import com.pizzahub.entities.Customer;
import com.pizzahub.repository.CartItemRepository;
import com.pizzahub.repository.ProductRepository;
import com.pizzahub.repository.CustomerRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CustomerRepository userRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CartItemRepository cartItemRepo;

	@Override
	public String addToCart(CartItemDto cartItemDto, Long userId, Long prodId) {
		
		try {
		Customer user=userRepo.findById(userId).get();
		Product prod=prodRepo.findById(prodId).get();
		CartItem cartItem=modelMapper.map(cartItemDto, CartItem.class);
		cartItem.setTotalPrice(cartItem.getQuantity()*prod.getPrice());
		user.getCart().addCartItem(cartItem);
		user.getCart().setTotalCartPrice(user.getCart().getTotalCartPrice()+cartItem.getTotalPrice());
		user.getCart().setTotalItems(user.getCart().getTotalItems()+1);
		cartItem.setCartProduct(prod);
		cartItemRepo.save(cartItem);		
		return "added to cart";
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String deleteFromCart(Long cartItemId) {
		CartItem cartItem=cartItemRepo.findById(cartItemId).get();
		cartItem.getCart().setTotalCartPrice(cartItem.getCart().getTotalCartPrice()-cartItem.getTotalPrice());
		cartItem.getCart().setTotalItems(cartItem.getCart().getTotalItems()-1);
		cartItem.getCart().removeCartItem(cartItem);
		cartItemRepo.delete(cartItem);
		
		return "Deleted Successfully";
	}

}
