package com.ecommercek.ecommercek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommercek.ecommercek.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
