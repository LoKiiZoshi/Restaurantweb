package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.NonVegetarianCart;
import com.Foodweb.Springproject.Model.User;

public interface NonVegetarianCartService {

	void addNonVegetarianCart(NonVegetarianCart nonvegetarianCart);
	void deleteNonVegetarianCart(int id);
	void updateNonVegetarianCart(NonVegetarianCart nonvegetarianCart);
	NonVegetarianCart getNonVegetarianCartById(int id);
	List<NonVegetarianCart>getAllNonVegetarianCart();
	
	List<NonVegetarianCart>findByUser(User user);
	
	
	 
}
