package com.pizzahub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.entities.Customer;
import com.pizzahub.entities.Product;
import com.pizzahub.entities.Wishlist;
import com.pizzahub.repository.CustomerRepository;
import com.pizzahub.repository.ProductRepository;
import com.pizzahub.repository.WishlistRepository;

@Service
@Transactional
public class WishlistImpl implements WishlistService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private WishlistRepository wishRepo;
	
	@Autowired
	private ProductRepository prodRepo;



	@Override
	public String addToWishlist(String prodName, String custEmail) {
		
		Customer cust=custRepo.findByEmail(custEmail);
		
		if(cust==null) {
			return "Customer does not exists";
		}
		
		Product prod=prodRepo.getByProductName(prodName);
		if(prod==null) {
			return "product does not exists";
		}
		Wishlist wish=new Wishlist();	
		cust.setWishlist(wish);
		wish.addProduct(prod);		
		wishRepo.save(wish);		
		return "Added to Wishlist" ;	
	}

	

}
