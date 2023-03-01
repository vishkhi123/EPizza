package com.pizzahub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzahub.entities.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

}
