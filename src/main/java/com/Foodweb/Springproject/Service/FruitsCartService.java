package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.FruitsCart;
import com.Foodweb.Springproject.Model.User;

public interface FruitsCartService {
	void addFruitsCart(FruitsCart fruitscart);
	void deleteFruitsCart(int id);
	void updateFruitsCart(FruitsCart fruitscart);
	FruitsCart getFruitsCartById(int id);
	List<FruitsCart>getAllFruitsCart();
	
	List<FruitsCart>findByUser(User user);
	
	

}
