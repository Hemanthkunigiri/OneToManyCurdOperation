package com.ecommerce.resporites;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
