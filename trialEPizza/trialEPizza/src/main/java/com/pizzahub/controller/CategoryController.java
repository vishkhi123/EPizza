package com.pizzahub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahub.dto.CategoryDto;
import com.pizzahub.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	public String addCategory(@RequestBody CategoryDto catDto) {
		
		return catService.addCategory(catDto);	
		}
	@GetMapping("/getCat")
	public List<CategoryDto> getAllCategories()
	{
		return catService.getAllCategories().stream().map(e -> modelMapper.map(e,CategoryDto.class))
				.collect(Collectors.toList());
	}

}
