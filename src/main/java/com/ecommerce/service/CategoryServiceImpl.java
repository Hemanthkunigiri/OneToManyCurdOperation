package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Category;
import com.ecommerce.resporites.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public String createCategory(Category category) {
        categoryRepo.save(category);
        return "Category inserted successfully";
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public String updateCategory(int id, Category category) {
        if (categoryRepo.existsById(id)) {
            category.setCategory_id(id);
            categoryRepo.save(category);
            return "Successfully updated";
        } else {
            return "Category not found";
        }
    }

    @Override
    public String deleteCategoryById(int id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
            return "Successfully deleted";
        } else {
            return "Category not found";
        }
    }
}

