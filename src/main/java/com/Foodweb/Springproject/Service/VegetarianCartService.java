package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Model.VegetarianCart;

public interface VegetarianCartService {
      
	void addVegetarianCart(VegetarianCart vegetariancart);
	void deleteVegetarianCart(int id);
	
	void updateVegetarianCart(VegetarianCart vegetariancart);
	VegetarianCart getVegetarianCartById(int id);
	List<VegetarianCart>getAllVegetarianCart();
	
	List<VegetarianCart> findByUser(User user);
}  
