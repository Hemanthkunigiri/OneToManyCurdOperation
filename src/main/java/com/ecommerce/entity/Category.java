package com.ecommerce.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
    @Column(name="category_id")
    @GeneratedValue(strategy =GenerationType.AUTO)
	private int category_id;

    @Column(name="category_name")
    private  String category_name;
    
    @OneToMany(mappedBy = "category",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnore // Ignore this property during JSON serialization
    private List<Product> products;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + ", products=" + products
				+ "]";
	}

	public Category(int category_id, String category_name, List<Product> products) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
}
