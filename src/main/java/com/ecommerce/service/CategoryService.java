package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategory();
	public String createCategory(Category category);
	public Optional<Category> getCategoryById(int id);
	public String updateCategory(int id,Category category);
	public String deleteCategoryById(int id);
	
}
