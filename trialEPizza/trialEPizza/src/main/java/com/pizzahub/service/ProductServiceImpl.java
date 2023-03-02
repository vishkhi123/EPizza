package com.pizzahub.service;

import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzahub.dto.ProductDto;
import com.pizzahub.entities.Category;
import com.pizzahub.entities.Product;
import com.pizzahub.repository.CategoryRepository;
import com.pizzahub.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addProduct(ProductDto proDto, String proname) {
		Category cat=catRepo.getByCategoryName(proname);
		if(cat!=null)
		{
			Product prod=proRepo.getByProductName(proDto.getProductName());
			if(prod!=null)
			{
				return "product already exists";
			}
			prod=modelMapper.map(proDto, Product.class);
			cat.addProduct(prod);
			proRepo.save(prod);
			
			return "Product Added SUccessfully";
		}
		return "category does not exist!!!";
	}

	@Override
	public List<Product> getAllProd() {
		
		return proRepo.findAll();
	}


	@Override
	public List<Product> getCat(String catName) {
Category cat=catRepo.getByCategoryName(catName);
		
		if(cat !=null) {
			return cat.getProducts();
		}
		
		return null;
	}

	@Override
	public String deleteProduct(String prodName) {
		Product prod=proRepo.getByProductName(prodName);
		if(prod!=null)
		{
			prod.getProductCategory().removeProduct(prod);
			proRepo.delete(prod);
			return "Deleted Sucessfully!!!!";
		}
		
		return "Product Does Not Exists!!!!!";
	}

	@Override
	public String updateProd(ProductDto prodDto, Long prodId) {
		Product prod=proRepo.findById(prodId).get();
		if(prod!=null)
		{
			prod.setDescription(prodDto.getDescription());
			prod.setPrice(prodDto.getPrice());
			prod.setProductName(prodDto.getProductName());
			prod.setInStock(prodDto.isInStock());
		
			proRepo.save(prod);
			return "Updated SuccessFully!!!!";
		}
		return "Product Does Not Exists";
		
	}

	@Override
	public Product getProductByName(String prodName) {
		// TODO Auto-generated method stub
		return proRepo.getByProductName(prodName);
	}

	

}
