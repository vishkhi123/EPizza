package com.pizzahub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzahub.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category getByCategoryName(String categoryName);

}
