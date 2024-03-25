package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ecommerce.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public String createProduct(Product product);
	public Optional<Product> getProductById(int id);
	public String updateProduct(Product product,int id);
	public String deleteProductById(int id);
	
}
