package com.pizzahub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzahub.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	Product getByProductName(String productName);


}
