package com.ecommercek.ecommercek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercek.ecommercek.models.Category;
import com.ecommercek.ecommercek.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
	
	public Category createCategory(Category category) {
	  return categoryRepository.save(category);
	}

	public void editCategory(Long categoryId, Category editCategory) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setName(editCategory.getName());
			category.setDescription(editCategory.getDescription());
			category.setImageUrl(editCategory.getImageUrl());
			
			categoryRepository.save(category);
		}
		
	}
	
}
