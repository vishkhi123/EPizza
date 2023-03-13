package com.pizzahub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzahub.entities.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	


}
