package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Model.VegetarianCart;
import com.Foodweb.Springproject.Repositry.VegetarianCartRepositry;
import com.Foodweb.Springproject.Service.VegetarianCartService;

@Service
public class VegetarianCartServiceimpl implements VegetarianCartService {
	
	@Autowired
	private VegetarianCartRepositry vegetarianrepo;
	

	@Override
	public void addVegetarianCart(VegetarianCart vegetariancart) {
		
		vegetarianrepo.save(vegetariancart);
		
	}

	@Override
	public void deleteVegetarianCart(int id) {
		
	   vegetarianrepo.deleteById(id); 
		
	}

	@Override
	public void updateVegetarianCart(VegetarianCart vegetariancart) {
		vegetarianrepo.save(vegetariancart);
		
	}

	@Override
	public VegetarianCart getVegetarianCartById(int id) {
		
		return vegetarianrepo.findById(id).get();
	}

	@Override
	public List<VegetarianCart> getAllVegetarianCart() {
		
		return vegetarianrepo.findAll();
	}

	@Override
	public List<VegetarianCart> findByUser(User user) {
		
		return vegetarianrepo.findByUser(user); 
	}
	

}
