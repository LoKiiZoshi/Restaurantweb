package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.Product;
import com.Foodweb.Springproject.Repositry.ProductRepositry;
import com.Foodweb.Springproject.Service.ProductService;
@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired
    private ProductRepositry productRepo;

	@Override
	public void addproduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public void deleteproduct(Long id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public void updateproduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public Product getproductById(Long id) {
		
		return productRepo.findById(id).get();
	}

	@Override
	public List<Product> getAllproduct() {
		
		return productRepo.findAll();
	}

	
	
}
