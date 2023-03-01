package com.pizzahub.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.dto.CartItemDto;
import com.pizzahub.dto.CustomerDto;
import com.pizzahub.entities.CartItem;
import com.pizzahub.entities.Customer;
import com.pizzahub.entities.Product;
import com.pizzahub.entities.ShoppingCart;
import com.pizzahub.entities.Wishlist;
import com.pizzahub.repository.CartItemRepository;
import com.pizzahub.repository.CustomerRepository;
import com.pizzahub.repository.ProductRepository;
import com.pizzahub.repository.ShoppingCartRepository;
import com.pizzahub.repository.WishlistRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private ShoppingCartRepository shoppingRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private WishlistRepository wishRepo;
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CustomerDto validateCustomer(String email,String password) {
		Customer cust=custRepo.getByEmailAndPassword(email, password);
		if(cust!=null) {
			return modelMapper.map(cust, CustomerDto.class);
		}
		return null;
	}
	
	@Override
	public String addCustomerDetails(CustomerDto userDto) {
		Customer user=custRepo.findByEmail(userDto.getEmail());
		if(user==null)
		{
			user=modelMapper.map(userDto, Customer.class);
			
			Customer cust=custRepo.save(user);
			ShoppingCart cart=new ShoppingCart();
			cust.setCart(cart);
			cart.setCartOwner(cust);
			shoppingRepo.save(cart);
			Wishlist wish=new Wishlist();	
			cust.setWishlist(wish);
			wish.setCustomer(cust);
			wishRepo.save(wish);
			return "customer added succesfully";
		}
		return "invalid details";
		
	}
	
	@Override
	public String addProductToWishlist(String email,String prodName) {
		Customer cust=custRepo.findByEmail(email);
		Product prod=prodRepo.getByProductName(prodName);
		Wishlist wish= cust.getWishlist();
		wish.addProduct(prod);
		wishRepo.save(wish);
				
		return "added to wishlist";
	}
	
	@Override
	public String removeProductFromWishlist(String custEmail, String prodName) {
		Customer cust=custRepo.findByEmail(custEmail);
		Product prod=prodRepo.getByProductName(prodName);
		Wishlist wish= cust.getWishlist();
		wish.removeProduct(prod);
		wishRepo.save(wish);
				
		return "removed from wishlist";				
	}
	
	
	@Override
	public String addToCart(CartItemDto cartItemDto, String custEmail, String prodName) {
		
		try {
		Customer user=custRepo.findByEmail(custEmail);
		Product prod=prodRepo.getByProductName(prodName);
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
	

	

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		
		if(custRepo.existsById(customer.getId()))
		{
			return custRepo.save(customer);
		}
		return null;
	}

	

	

}
