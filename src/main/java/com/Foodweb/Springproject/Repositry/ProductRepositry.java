package com.Foodweb.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.Product;

public interface ProductRepositry extends JpaRepository<Product, Long> {
	

}
