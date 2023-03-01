package com.pizzahub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahub.dto.ProductDto;
import com.pizzahub.entities.Category;
import com.pizzahub.entities.Product;
import com.pizzahub.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductService proService;

	@PostMapping("/add/{catname}")
	public String addProduct(@RequestBody ProductDto proDto, @PathVariable String catname) {
		return proService.addProduct(proDto, catname);
	}

	@GetMapping("/getProduct")
	public List<ProductDto> getAllProd() {
		return proService.getAllProd().stream().map(e -> modelMapper.map(e, ProductDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/getProduct/{catName}")
	public List<ProductDto> getByCategory(@PathVariable String catName) {
		return proService.getCat(catName).stream().map(e -> modelMapper.map(e, ProductDto.class))
				.collect(Collectors.toList());

	}
	
	@DeleteMapping("/delete/{prodName}")
	public String deleteProduct(@PathVariable String prodName)
	{
		return proService.deleteProduct(prodName);
	}
	
	@PutMapping("/update/{prodId}")
	public String updateProd(@RequestBody ProductDto prodDto,@PathVariable Long prodId)
	{
		return proService.updateProd(prodDto,prodId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
