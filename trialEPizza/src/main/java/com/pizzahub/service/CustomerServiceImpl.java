package com.pizzahub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.dto.CartDto;
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

//	@Autowired
//	private JavaMailSender javaMailSender;

	@Override
	public CustomerDto validateCustomer(String email, String password) {
		Customer cust = custRepo.getByEmailAndPassword(email, password);
		if (cust != null) {
			return modelMapper.map(cust, CustomerDto.class);
		}
		return null;
	}

	// -------------------------------------------------------------------------------

//	public void sendRegistrationEmail(String email, String name,String password) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(email);
//		message.setFrom("dahaputep@gmail.com");
//		message.setSubject("Registration Successful");
//		message.setText(
//				"Dear "+name+",\n\nWe are excited to inform you that your registration with PizzaHub has been successful. You can now access our services using the credentials you provided during the registration process.\n\nAs a registered user, you will have access to all the features of our platform. You can log in to your account using the following credentials:\n\nEmail: ["+email+"]\nPassword: ["+password+"]\n\nPlease keep your login details safe and do not share them with anyone. If you have any questions or need assistance, please don't hesitate to contact us at pizzahub@phub.com.in .\n\nWe are committed to providing you with the best possible service, and we look forward to serving you.\n\nBest regards,\n PizzaHub");
//		javaMailSender.send(message);
//	}

	// --------------------------------------------------------------------------------------

	@Override
	public String addCustomerDetails(CustomerDto userDto) {
		Customer user = custRepo.findByEmail(userDto.getEmail());
		if (user == null) {
			user = modelMapper.map(userDto, Customer.class);

			Customer cust = custRepo.save(user);
			ShoppingCart cart = new ShoppingCart();
			cust.setCart(cart);
			cart.setCartOwner(cust);
			shoppingRepo.save(cart);
			Wishlist wish = new Wishlist();
			cust.setWishlist(wish);
			wish.setCustomer(cust);
			wishRepo.save(wish);
			
	//		sendRegistrationEmail(cust.getEmail(),cust.getFirstName(),cust.getPassword());
			return "customer added succesfully";
		}
		return "invalid details";

	}

	@Override
	public String addProductToWishlist(String email, String prodName) {
		Customer cust = custRepo.findByEmail(email);
		Product prod = prodRepo.getByProductName(prodName);
		Wishlist wish = cust.getWishlist();
		wish.addProduct(prod);
		wishRepo.save(wish);

		return "added to wishlist";
	}

	@Override
	public String removeProductFromWishlist(String custEmail, String prodName) {
		Customer cust = custRepo.findByEmail(custEmail);
		Product prod = prodRepo.getByProductName(prodName);
		Wishlist wish = cust.getWishlist();
		wish.removeProduct(prod);
		wishRepo.save(wish);

		return "removed from wishlist";
	}

	@Override
	public String addToCart(CartItemDto cartItemDto, String custEmail, String prodName) {

		try {
			Customer user = custRepo.findByEmail(custEmail);
			Product prod = prodRepo.getByProductName(prodName);
			CartItem cartItem = modelMapper.map(cartItemDto, CartItem.class);
//			cartItem.setTotalPrice(cartItem.getQuantity() * prod.getPrice());
			user.getCart().addCartItem(cartItem);
			user.getCart().setTotalCartPrice(user.getCart().getTotalCartPrice() + cartItem.getTotalPrice());
			user.getCart().setTotalItems(user.getCart().getTotalItems() + 1);
			cartItem.setCartProduct(prod);
			cartItemRepo.save(cartItem);
			return "added to cart";
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<CartDto> getAllCartItems(String custEmail){
		Customer cust=custRepo.findByEmail(custEmail);
		List<CartDto> abc=new ArrayList<CartDto>();
		abc=cust.getCart().getCartItems().stream().map((e)-> {
			CartDto a=new CartDto();
			
			a.setProdImage(e.getCartProduct().getProdImage());
			a.setCartId(e.getId());
			a.setProductName(e.getCartProduct().getProductName());
			a.setQuantity(e.getQuantity());
			a.setTotalPrice(e.getTotalPrice());
			
			;
			return a;
		}).collect(Collectors.toList());
		return abc;
	}
	

	@Override
	public String deleteFromCart(Long cartItemId) {
		CartItem cartItem = cartItemRepo.findById(cartItemId).get();
		cartItem.getCart().setTotalCartPrice(cartItem.getCart().getTotalCartPrice() - cartItem.getTotalPrice());
		cartItem.getCart().setTotalItems(cartItem.getCart().getTotalItems() - 1);
		cartItem.getCart().removeCartItem(cartItem);
		cartItemRepo.delete(cartItem);

		return "Deleted Successfully";
	}

	@Override
	public String updateCustomerDetails(CustomerDto customer) {

		Customer cust=custRepo.findByEmail(customer.getEmail());
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setMobileNo(customer.getMobileNo());
		cust.setAddress(customer.getAddress());
		cust.setPincode(customer.getPincode());	
		 custRepo.save(cust);
		 return "Update Successfully";
	}

}
