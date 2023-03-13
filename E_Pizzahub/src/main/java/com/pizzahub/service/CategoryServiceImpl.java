package com.pizzahub.service;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.dto.CategoryDto;
import com.pizzahub.entities.Category;
import com.pizzahub.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String addCategory(CategoryDto catDto) {
		
		Category cat=catRepo.getByCategoryName(catDto.getCategoryName());
		
	if(cat!=null)
	{
		return "Category Exists";
	}
	cat=modelMapper.map(catDto, Category.class);
	catRepo.save(cat);
	return "Category Added successfully" ;
	}

	@Override
	public Collection<Category> getAllCategories() {
		
		return catRepo.findAll();
	}

}
