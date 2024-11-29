package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.Product;

public interface ProductService {
	
	void addproduct(Product product); 
	void deleteproduct(Long id);
	void updateproduct(Product product);
	Product getproductById(Long id);    
	List<Product>getAllproduct();
    
}
