package com.pizzahub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzahub.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	//Customer getCustomer(String email);
	
	Customer findByEmail(String email);
	Customer getByEmailAndPassword(String email,String password);


}
