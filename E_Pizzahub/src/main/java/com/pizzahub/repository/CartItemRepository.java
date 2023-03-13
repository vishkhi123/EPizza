package com.pizzahub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzahub.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
