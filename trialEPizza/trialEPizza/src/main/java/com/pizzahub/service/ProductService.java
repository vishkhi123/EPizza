package com.pizzahub.service;

import java.util.Collection;
import java.util.List;

import com.pizzahub.dto.ProductDto;
import com.pizzahub.entities.Product;


public interface ProductService {

	String addProduct(ProductDto proDto, String proname);

	List<Product> getAllProd();

	List<Product> getCat(String catName);

	String deleteProduct(String prodName);

	String updateProd(ProductDto prodDto, Long prodId);

}
