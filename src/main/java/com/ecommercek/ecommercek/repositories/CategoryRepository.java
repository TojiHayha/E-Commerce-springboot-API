package com.ecommercek.ecommercek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommercek.ecommercek.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
