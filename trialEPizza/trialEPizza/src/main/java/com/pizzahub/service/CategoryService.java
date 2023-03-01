package com.pizzahub.service;

import java.util.Collection;

import com.pizzahub.dto.CategoryDto;
import com.pizzahub.dto.ProductDto;
import com.pizzahub.entities.Category;

public interface CategoryService {
	
	String addCategory(CategoryDto category);

	Collection<Category> getAllCategories();

}
