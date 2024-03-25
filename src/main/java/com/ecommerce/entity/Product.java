package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	
	@Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
    
    @Column(name="product_name")
    private String product_name;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")

    private Category category;	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Product(int product_id, String product_name, Category category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
	}




	public int getProduct_id() {
		return product_id;
	}




	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}




	public String getProduct_name() {
		return product_name;
	}




	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", category=" + category + "]";
	}
	
	
	
	

}
