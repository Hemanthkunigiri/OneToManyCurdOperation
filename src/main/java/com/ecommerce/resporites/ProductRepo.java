package com.ecommerce.resporites;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
