package com.ecommercek.ecommercek.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercek.ecommercek.dto.ProductDto;
import com.ecommercek.ecommercek.models.Category;
import com.ecommercek.ecommercek.repositories.CategoryRepository;
import com.ecommercek.ecommercek.services.ProductService;
import com.ecommercek.ecommercek.util.ApiResponse;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getProducts(){
		List<ProductDto> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
		if(!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
		}
		productService.createProduct(productDto, optionalCategory.get());
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added"), HttpStatus.CREATED);
	}
	
	@PostMapping("/update/{productId}")
	public ResponseEntity<ApiResponse> editProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) throws Exception{
		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
		if(!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
		}
		productService.editProduct(productDto, productId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
	}
}
