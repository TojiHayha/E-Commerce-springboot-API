package com.ecommercek.ecommercek.dto;

import jakarta.validation.constraints.NotNull;

public class ProductDto {

	private Long id;
	private @NotNull String name;
	private @NotNull String imageUrl;
	private @NotNull double price;
	private @NotNull String description;
	private @NotNull Long categoryId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDto() {
		super();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	} 
	
	
	
	
}
