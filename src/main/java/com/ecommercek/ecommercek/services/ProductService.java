package com.ecommercek.ecommercek.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercek.ecommercek.dto.ProductDto;
import com.ecommercek.ecommercek.models.Category;
import com.ecommercek.ecommercek.models.Product;
import com.ecommercek.ecommercek.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDto> getAllProducts(){
		List<Product> products = productRepository.findAll();
		
		List<ProductDto> productDtos = new ArrayList<>();
		for(Product product: products) {
			productDtos.add(getProductDto(product));
		}
		return productDtos;
	}
	
	public ProductDto getProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setImageUrl(product.getImageUrl());
		productDto.setCategoryId(product.getCategory().getId());
		productDto.setId(product.getId());
		return productDto;
	}
	
	
	public void createProduct(ProductDto productDto, Category category) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setImageUrl(productDto.getImageUrl());
		product.setCategory(category);
		
		productRepository.save(product);
	}

	public void editProduct(ProductDto productDto, Long productId) throws Exception  {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(!optionalProduct.isPresent()) {
			throw new Exception("product not present");
		}
		Product product = optionalProduct.get();		
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setImageUrl(productDto.getImageUrl());
		productRepository.save(product);
	}
	
}
