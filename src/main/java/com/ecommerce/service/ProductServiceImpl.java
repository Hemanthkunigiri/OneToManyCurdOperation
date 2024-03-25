package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.resporites.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    @Override
    public String createProduct(Product product) {
        productRepo.save(product);
        return "Product created successfully";
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public String updateProduct(Product product, int id) {
        if (productRepo.existsById(id)) {
            product.setProduct_id(id);
            productRepo.save(product);
            return "Product updated successfully";
        } else {
            return "Product not found";
        }
    }

    @Override
    public String deleteProductById(int id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }
}
