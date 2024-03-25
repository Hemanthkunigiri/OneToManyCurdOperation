package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.service.CategoryService;

@RestController
public class CategoryController 
{
	 @Autowired
	   CategoryService categoryService;

	    @GetMapping("/api/categories")
	    public List<Category> getAllcategory() {
	        return categoryService.getAllCategory();
	    }

	    @PostMapping("/api/categories")
	    public String createCategory(@RequestBody Category category) {
	        return  categoryService.createCategory(category);
	    }

	    @GetMapping("/api/categories/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
	        Optional<Category> category = categoryService.getCategoryById(id);
	        if (category.isPresent()) {
	            return ResponseEntity.ok(category.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/api/categories/{id}")
	    public String updateCategorytById(@RequestBody Category category, @PathVariable int id) {
	        return  categoryService.updateCategory(id, category);
	    }

	    @DeleteMapping("/api/categories/{id}")
	    public String deleteCategoryById(@PathVariable int id) {
	        return  categoryService.deleteCategoryById(id);
	    }

}
