package com.pizzahub.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.dto.ShoppingCartDto;
import com.pizzahub.entities.ShoppingCart;
import com.pizzahub.entities.Customer;
import com.pizzahub.repository.ShoppingCartRepository;
import com.pizzahub.repository.CustomerRepository;

@Service
@Transactional
public class ShoppingCartImpl implements ShoppingCartService {
	
	@Autowired
	private CustomerRepository userRepo;
	
	@Autowired
	private ShoppingCartRepository shoppingRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String createCart(ShoppingCartDto shoppingDto,Long id) {
		Customer user=userRepo.findById(id).get();
		if(user==null)
		{
			return "Please Login !!!!!!";
		}
		ShoppingCart shopCart=modelMapper.map(shoppingDto, ShoppingCart.class);
		shopCart.setCartOwner(user);
		user.setCart(shopCart);		
		shoppingRepo.save(shopCart);
		return "Cart Created Succesfully";
	}

}
