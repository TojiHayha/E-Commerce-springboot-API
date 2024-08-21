package com.ecommercek.ecommercek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercek.ecommercek.models.Category;
import com.ecommercek.ecommercek.repositories.CategoryRepository;
import com.ecommercek.ecommercek.services.CategoryService;
import com.ecommercek.ecommercek.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "a new category created"), HttpStatus.OK);
	}

	@PostMapping("/update/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		if(!categoryRepository.existsById(categoryId)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.NOT_FOUND);
		}
		categoryService.editCategory(categoryId, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "a new category created"), HttpStatus.OK);
		
	}

}
