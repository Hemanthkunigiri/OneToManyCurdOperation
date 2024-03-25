package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/api/products")
    public String createProduct(@RequestBody Product product) {

    	System.out.println(product);
    	System.out.println("category id--> "+product.getCategory().getCategory_id());
        // Retrieve the Category object by its ID
        Optional<Category> optionalCategory = categoryService.getCategoryById(product.getCategory().getCategory_id());
        
        if (optionalCategory.isPresent()) {
            // If the optional contains a value, set the Category object for the Product
            product.setCategory(optionalCategory.get());
            return productService.createProduct(product);
        } else {
            // Handle the case where the Category with the provided ID does not exist
            return "Error: Category not found";
        }
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/api/products/{id}")
    public String updateProductById(@RequestBody Product product, @PathVariable int id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/api/products/{id}")
    public String deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);
    }

}
